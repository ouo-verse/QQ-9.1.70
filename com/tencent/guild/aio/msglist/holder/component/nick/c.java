package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.view.View;
import com.tencent.aio.exception.AIOException;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\b\n*\u00013\u0018\u0000 :2\u00020\u0001:\u0001;B\u000f\u0012\u0006\u00107\u001a\u00020\u001e\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J&\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0014H\u0016J\u0016\u0010\u001b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u001a0\u00190\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0007H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00020*j\b\u0012\u0004\u0012\u00020\u0002`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00050/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006<"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/c;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "l1", "", "updateType", "", "tinyId", "", "k1", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "state", "handleUIState", "", "Ljava/lang/Class;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildMsgNickState;", "getObserverStates", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "d1", "getTag", "Lcom/tencent/guild/aio/msglist/holder/component/nick/NickLinearLayout;", "f", "Lcom/tencent/guild/aio/msglist/holder/component/nick/NickLinearLayout;", "nickView", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", tl.h.F, "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "currentMsgItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "nickItemList", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "childPlaceholder", "com/tencent/guild/aio/msglist/holder/component/nick/c$b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/guild/aio/msglist/holder/component/nick/c$b;", "childHelper", "root", "<init>", "(Landroid/view/View;)V", "D", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b childHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NickLinearLayout nickView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem currentMsgItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<r> nickItemList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<View, Integer> childPlaceholder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/msglist/holder/component/nick/c$b", "Lcom/tencent/guild/aio/msglist/holder/component/nick/q;", "Landroid/view/View;", "childNickView", "", "position", "", "addView", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements q {
        b() {
        }

        @Override // com.tencent.guild.aio.msglist.holder.component.nick.q
        public void addView(@NotNull View childNickView, int position) {
            int i3;
            Intrinsics.checkNotNullParameter(childNickView, "childNickView");
            if (childNickView.getParent() == null) {
                int childCount = c.this.nickView.getChildCount();
                int childCount2 = c.this.nickView.getChildCount() - 1;
                while (true) {
                    int i16 = childCount2;
                    i3 = childCount;
                    childCount = i16;
                    if (-1 >= childCount) {
                        break;
                    }
                    Object obj = c.this.childPlaceholder.get(c.this.nickView.getChildAt(childCount));
                    Intrinsics.checkNotNull(obj);
                    if (position >= ((Number) obj).intValue()) {
                        break;
                    } else {
                        childCount2 = childCount - 1;
                    }
                }
                c.this.childPlaceholder.put(childNickView, Integer.valueOf(position));
                c.this.nickView.addView(childNickView, i3);
                return;
            }
            throw new AIOException("can not repeat add child " + childNickView);
        }
    }

    public c(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        Context context = root.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "root.context");
        NickLinearLayout nickLinearLayout = new NickLinearLayout(context);
        nickLinearLayout.setExtraWidth(ViewUtils.dpToPx(70.0f));
        nickLinearLayout.setGravity(17);
        this.nickView = nickLinearLayout;
        ArrayList<r> arrayList = new ArrayList<>();
        this.nickItemList = arrayList;
        this.childPlaceholder = new LinkedHashMap();
        this.childHelper = new b();
        Context context2 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "nickView.context");
        arrayList.add(l1(new GuildNickItem(context2)));
        Context context3 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "nickView.context");
        arrayList.add(l1(new GuildSVipNamePlateItem(context3)));
        Context context4 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "nickView.context");
        arrayList.add(l1(new GuildPersonalMedal(context4)));
        Context context5 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "nickView.context");
        arrayList.add(l1(new GuildRoleNickItem(context5)));
        Context context6 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context6, "nickView.context");
        arrayList.add(l1(new GuildLevelRoleNickItem(context6)));
        Context context7 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context7, "nickView.context");
        arrayList.add(l1(new GuildRobotNickItem(context7)));
        Context context8 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context8, "nickView.context");
        arrayList.add(l1(new GuildGameNickItem(context8)));
        Context context9 = nickLinearLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context9, "nickView.context");
        arrayList.add(l1(new GuildTimestampNickItem(context9)));
    }

    private final void k1(int updateType, String tinyId) {
        GuildMsgItem guildMsgItem = this.currentMsgItem;
        if (guildMsgItem != null && guildMsgItem.getMsgRecord().senderUid.equals(tinyId)) {
            Iterator<r> it = this.nickItemList.iterator();
            while (it.hasNext()) {
                it.next().f(guildMsgItem, updateType);
            }
        }
    }

    private final r l1(r item) {
        item.g(new com.tencent.guild.aio.msglist.holder.component.nick.b(this.childHelper, this.nickItemList.size()));
        return item;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (msgItem instanceof GuildMsgItem) {
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            this.currentMsgItem = guildMsgItem;
            Iterator<r> it = this.nickItemList.iterator();
            while (it.hasNext()) {
                it.next().a(guildMsgItem, payloads);
            }
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return this.nickView;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new d();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<Class<? extends GuildMsgNickState>> getObserverStates() {
        List<Class<? extends GuildMsgNickState>> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(GuildMsgNickState.class);
        return listOf;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public String getTag() {
        return "GuildBubbleNickComponent";
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildMsgNickState) {
            GuildMsgNickState guildMsgNickState = (GuildMsgNickState) state;
            k1(guildMsgNickState.getUpdateType(), guildMsgNickState.getTinyId());
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
