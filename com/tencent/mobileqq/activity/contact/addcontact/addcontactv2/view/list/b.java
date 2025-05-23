package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.AddContactGroupViewHolder;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.troop.flock.QeventPB$Feed;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0084\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\b\u0002\u0010 \u001a\u00020\u001d\u0012:\u0010*\u001a6\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060!j\u0002`'\u0012%\u0010/\u001a!\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060+j\u0002`,\u00a2\u0006\u0004\b5\u00106J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fRH\u0010*\u001a6\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060!j\u0002`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R3\u0010/\u001a!\u0012\u0013\u0012\u00110%\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00060+j\u0002`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000400j\b\u0012\u0004\u0012\u00020\u0004`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/AddContactGroupViewHolder;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/b;", "newList", "", "k0", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/c;", "event", "l0", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "getItemCount", "holder", "position", "i0", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;", "avatarDelegate", "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", "mayKnowManager", "", "D", "Ljava/lang/String;", "recommendTraceId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/DislikeRecommendItemListener;", "E", "Lkotlin/jvm/functions/Function2;", "dislikeItemListener", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/MoreViewItemListener;", UserInfo.SEX_FEMALE, "Lkotlin/jvm/functions/Function1;", "moreViewItemListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", "dataList", "<init>", "(Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;Lcom/tencent/mobileqq/app/MayknowRecommendManager;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "H", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b extends RecyclerView.Adapter<AddContactGroupViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MayknowRecommendManager mayKnowManager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String recommendTraceId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<String, AddContactDataType, Unit> dislikeItemListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function1<AddContactDataType, Unit> moreViewItemListener;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a avatarDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.b$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50149);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a avatarDelegate, @NotNull MayknowRecommendManager mayKnowManager, @NotNull String recommendTraceId, @NotNull Function2<? super String, ? super AddContactDataType, Unit> dislikeItemListener, @NotNull Function1<? super AddContactDataType, Unit> moreViewItemListener) {
        Intrinsics.checkNotNullParameter(avatarDelegate, "avatarDelegate");
        Intrinsics.checkNotNullParameter(mayKnowManager, "mayKnowManager");
        Intrinsics.checkNotNullParameter(recommendTraceId, "recommendTraceId");
        Intrinsics.checkNotNullParameter(dislikeItemListener, "dislikeItemListener");
        Intrinsics.checkNotNullParameter(moreViewItemListener, "moreViewItemListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avatarDelegate, mayKnowManager, recommendTraceId, dislikeItemListener, moreViewItemListener);
            return;
        }
        this.avatarDelegate = avatarDelegate;
        this.mayKnowManager = mayKnowManager;
        this.recommendTraceId = recommendTraceId;
        this.dislikeItemListener = dislikeItemListener;
        this.moreViewItemListener = moreViewItemListener;
        this.dataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull AddContactGroupViewHolder holder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b bVar = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(bVar, "dataList[position]");
        holder.m(bVar, position, this.avatarDelegate, this.mayKnowManager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public AddContactGroupViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AddContactGroupViewHolder) iPatchRedirector.redirect((short) 6, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gve, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        AddContactGroupViewHolder addContactGroupViewHolder = new AddContactGroupViewHolder(itemView, this.recommendTraceId, this.dislikeItemListener, this.moreViewItemListener);
        itemView.setTag(addContactGroupViewHolder);
        return addContactGroupViewHolder;
    }

    public final void k0(@NotNull List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b> newList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.dataList.clear();
        this.dataList.addAll(newList);
        notifyDataSetChanged();
    }

    public final void l0(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.c event) {
        PBUInt64Field pBUInt64Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        String a16 = event.a();
        if (TextUtils.isEmpty(a16) || this.dataList.isEmpty()) {
            return;
        }
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : ((com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b) obj).a()) {
                String str = null;
                if (cVar.c() == AddContactDataType.f293812GROUP) {
                    RecommendTroopItem f16 = cVar.f();
                    if (f16 != null) {
                        str = f16.uin;
                    }
                    if (Intrinsics.areEqual(str, a16)) {
                        a.e(f16, event.b());
                        QLog.d("AddContactListGroupAdapterV2", 2, "updateJoinStatus, troopUin: " + a16 + " state: " + event.b());
                        notifyItemChanged(i3);
                    }
                } else if (cVar.c() == AddContactDataType.FLOCK) {
                    QeventPB$Feed d16 = cVar.d();
                    if (d16 != null && (pBUInt64Field = d16.group_id) != null) {
                        str = Long.valueOf(pBUInt64Field.get()).toString();
                    }
                    if (Intrinsics.areEqual(str, a16)) {
                        QLog.d("AddContactListGroupAdapterV2", 2, "updateJoinStatus, troopUin: " + a16 + " state: " + event.b());
                        notifyItemChanged(i3);
                    }
                }
            }
            i3 = i16;
        }
    }

    public final void m0(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.c event) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        String a16 = event.a();
        if (TextUtils.isEmpty(a16) || this.dataList.isEmpty()) {
            return;
        }
        int i3 = 0;
        for (Object obj : this.dataList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : ((com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b) obj).a()) {
                if (cVar.c() == AddContactDataType.GUILD) {
                    RecommendTroopItem f16 = cVar.f();
                    if (f16 != null) {
                        str = f16.uin;
                    } else {
                        str = null;
                    }
                    if (Intrinsics.areEqual(str, a16)) {
                        a.e(f16, event.b());
                        QLog.d("AddContactListGroupAdapterV2", 2, "updateJoinStatusForGuild, guildId: " + a16 + " state: " + event.b());
                        notifyItemChanged(i3);
                    }
                }
            }
            i3 = i16;
        }
    }
}
