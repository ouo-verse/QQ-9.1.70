package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.e;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.f;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.o;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.p;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.r;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.AddContactSwipeMenuLayout;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.troop.flock.QeventPB$Feed;
import tencent.im.troop.flock.QeventPB$User;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011BS\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012:\u0010(\u001a6\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001ej\u0002`%\u00a2\u0006\u0004\b.\u0010/J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0016R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cRH\u0010(\u001a6\u0012\u0013\u0012\u00110\u001f\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110#\u00a2\u0006\f\b \u0012\b\b!\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u00060\u001ej\u0002`%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R$\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00040)j\b\u0012\u0004\u0012\u00020\u0004`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/AddContactListAdapterV2;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/f;", "newList", "", "j0", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/c;", "event", "k0", "l0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "onCreateViewHolder", "getItemCount", "holder", "position", "onBindViewHolder", "getItemViewType", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;", "avatarDelegate", "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", "mayKnowManager", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/DislikeRecommendItemListener;", "D", "Lkotlin/jvm/functions/Function2;", "dislikeItemListener", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "dataList", "<init>", "(Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;Lcom/tencent/mobileqq/app/MayknowRecommendManager;Lkotlin/jvm/functions/Function2;)V", UserInfo.SEX_FEMALE, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactListAdapterV2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MayknowRecommendManager mayKnowManager;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Function2<String, AddContactDataType, Unit> dislikeItemListener;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<f> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a avatarDelegate;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/AddContactListAdapterV2$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.AddContactListAdapterV2$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180930a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50145);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AddContactDataType.GUILD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AddContactDataType.FLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f180930a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AddContactListAdapterV2(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a avatarDelegate, @NotNull MayknowRecommendManager mayKnowManager, @NotNull Function2<? super String, ? super AddContactDataType, Unit> dislikeItemListener) {
        Intrinsics.checkNotNullParameter(avatarDelegate, "avatarDelegate");
        Intrinsics.checkNotNullParameter(mayKnowManager, "mayKnowManager");
        Intrinsics.checkNotNullParameter(dislikeItemListener, "dislikeItemListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, avatarDelegate, mayKnowManager, dislikeItemListener);
            return;
        }
        this.avatarDelegate = avatarDelegate;
        this.mayKnowManager = mayKnowManager;
        this.dislikeItemListener = dislikeItemListener;
        this.dataList = new ArrayList<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.dataList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, position)).intValue();
        }
        return this.dataList.get(position).a();
    }

    public final void j0(@NotNull List<? extends f> newList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) newList);
            return;
        }
        Intrinsics.checkNotNullParameter(newList, "newList");
        this.dataList.clear();
        this.dataList.addAll(newList);
        notifyDataSetChanged();
    }

    public final void k0(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.c event) {
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar;
        AddContactDataType addContactDataType;
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar2;
        AddContactDataType addContactDataType2;
        PBUInt64Field pBUInt64Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) event);
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
            f fVar = (f) obj;
            boolean z16 = fVar instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c;
            String str = null;
            if (z16) {
                cVar = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                addContactDataType = cVar.c();
            } else {
                addContactDataType = null;
            }
            if (addContactDataType == AddContactDataType.f293812GROUP) {
                RecommendTroopItem f16 = ((com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar).f();
                if (f16 != null) {
                    str = f16.uin;
                }
                if (Intrinsics.areEqual(str, a16)) {
                    a.e(f16, event.b());
                    QLog.d("AddContactListAdapterV2", 2, "updateJoinStatus, troopUin: " + a16 + " state: " + event.b());
                    notifyItemChanged(i3);
                }
            } else {
                if (z16) {
                    cVar2 = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar;
                } else {
                    cVar2 = null;
                }
                if (cVar2 != null) {
                    addContactDataType2 = cVar2.c();
                } else {
                    addContactDataType2 = null;
                }
                if (addContactDataType2 == AddContactDataType.FLOCK) {
                    QeventPB$Feed d16 = ((com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar).d();
                    if (d16 != null && (pBUInt64Field = d16.group_id) != null) {
                        str = Long.valueOf(pBUInt64Field.get()).toString();
                    }
                    if (Intrinsics.areEqual(str, a16)) {
                        QLog.d("AddContactListAdapterV2", 2, "updateJoinStatus, troopUin: " + a16 + " state: " + event.b());
                        notifyItemChanged(i3);
                    }
                }
            }
            i3 = i16;
        }
    }

    public final void l0(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.c event) {
        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar;
        AddContactDataType addContactDataType;
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
            f fVar = (f) obj;
            String str = null;
            if (fVar instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) {
                cVar = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                addContactDataType = cVar.c();
            } else {
                addContactDataType = null;
            }
            if (addContactDataType == AddContactDataType.GUILD) {
                RecommendTroopItem f16 = ((com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar).f();
                if (f16 != null) {
                    str = f16.uin;
                }
                if (Intrinsics.areEqual(str, a16)) {
                    a.e(f16, event.b());
                    QLog.d("AddContactListAdapterV2", 2, "updateJoinStatusForGuild, guildId: " + a16 + " state: " + event.b());
                    notifyItemChanged(i3);
                }
            }
            i3 = i16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull final RecyclerView.ViewHolder holder, int position) {
        String str;
        String str2;
        String str3;
        String str4;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        f fVar = this.dataList.get(position);
        Intrinsics.checkNotNullExpressionValue(fVar, "dataList[position]");
        f fVar2 = fVar;
        if ((fVar2 instanceof e) && (holder instanceof r)) {
            ((r) holder).m((e) fVar2, position);
            return;
        }
        if ((fVar2 instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) && (holder instanceof o)) {
            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) fVar2;
            int i3 = b.f180930a[cVar.c().ordinal()];
            int i16 = 1;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            QeventPB$Feed d16 = cVar.d();
                            if (d16 == null) {
                                return;
                            }
                            QeventPB$User qeventPB$User = d16.publisher.get();
                            o oVar = (o) holder;
                            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar = this.avatarDelegate;
                            String str5 = qeventPB$User.f436060id.get();
                            Intrinsics.checkNotNullExpressionValue(str5, "personItem.id.get()");
                            oVar.x0(aVar.c(str5, 1));
                            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar2 = this.avatarDelegate;
                            String str6 = qeventPB$User.f436060id.get();
                            Intrinsics.checkNotNullExpressionValue(str6, "personItem.id.get()");
                            Bitmap b16 = aVar2.b(str6, 1);
                            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar3 = this.avatarDelegate;
                            Context context = holder.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "holder.itemView.context");
                            oVar.E(d16, aVar3.f(context), b16);
                            Iterator<f> it = this.dataList.iterator();
                            while (it.hasNext()) {
                                f next = it.next();
                                if (next instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) {
                                    com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar2 = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) next;
                                    if (cVar2.c() != AddContactDataType.FLOCK) {
                                        continue;
                                    } else {
                                        QeventPB$Feed d17 = cVar2.d();
                                        if (d17 != null && (pBStringField = d17.f436058id) != null) {
                                            str4 = pBStringField.get();
                                        } else {
                                            str4 = null;
                                        }
                                        if (Intrinsics.areEqual(str4, d16.f436058id.get())) {
                                            break;
                                        } else {
                                            i16++;
                                        }
                                    }
                                }
                            }
                            a.a((o) holder, d16, i16);
                        }
                    } else {
                        RecommendTroopItem f16 = cVar.f();
                        if (f16 == null) {
                            return;
                        }
                        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar4 = this.avatarDelegate;
                        Context context2 = holder.itemView.getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "holder.itemView.context");
                        String str7 = f16.icon;
                        Intrinsics.checkNotNullExpressionValue(str7, "troopItem.icon");
                        Drawable h16 = aVar4.h(context2, str7);
                        o oVar2 = (o) holder;
                        oVar2.W(f16, h16);
                        Iterator<f> it5 = this.dataList.iterator();
                        while (it5.hasNext()) {
                            f next2 = it5.next();
                            if (next2 instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) {
                                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar3 = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) next2;
                                if (cVar3.c() != AddContactDataType.GUILD) {
                                    continue;
                                } else {
                                    RecommendTroopItem f17 = cVar3.f();
                                    if (f17 != null) {
                                        str3 = f17.uin;
                                    } else {
                                        str3 = null;
                                    }
                                    if (Intrinsics.areEqual(str3, f16.uin)) {
                                        break;
                                    } else {
                                        i16++;
                                    }
                                }
                            }
                        }
                        a.c(oVar2, f16, i16);
                    }
                } else {
                    RecommendTroopItem f18 = cVar.f();
                    if (f18 == null) {
                        return;
                    }
                    com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar5 = this.avatarDelegate;
                    String str8 = f18.uin;
                    Intrinsics.checkNotNullExpressionValue(str8, "troopItem.uin");
                    Drawable g16 = aVar5.g(str8);
                    o oVar3 = (o) holder;
                    oVar3.P(cVar, g16);
                    Iterator<f> it6 = this.dataList.iterator();
                    while (it6.hasNext()) {
                        f next3 = it6.next();
                        if (next3 instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) {
                            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar4 = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) next3;
                            if (cVar4.c() != AddContactDataType.f293812GROUP) {
                                continue;
                            } else {
                                RecommendTroopItem f19 = cVar4.f();
                                if (f19 != null) {
                                    str2 = f19.uin;
                                } else {
                                    str2 = null;
                                }
                                if (Intrinsics.areEqual(str2, f18.uin)) {
                                    break;
                                } else {
                                    i16++;
                                }
                            }
                        }
                    }
                    a.b(oVar3, f18, cVar.d(), i16);
                }
            } else {
                MayKnowRecommend e16 = cVar.e();
                if (e16 == null) {
                    return;
                }
                o oVar4 = (o) holder;
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar6 = this.avatarDelegate;
                String str9 = e16.uin;
                Intrinsics.checkNotNullExpressionValue(str9, "personItem.uin");
                oVar4.w0(aVar6.c(str9, 1));
                com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a aVar7 = this.avatarDelegate;
                String str10 = e16.uin;
                Intrinsics.checkNotNullExpressionValue(str10, "personItem.uin");
                oVar4.c0(cVar, aVar7.b(str10, 1), position, this.mayKnowManager);
                Iterator<f> it7 = this.dataList.iterator();
                while (it7.hasNext()) {
                    f next4 = it7.next();
                    if (next4 instanceof com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) {
                        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar5 = (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) next4;
                        if (cVar5.c() != AddContactDataType.PERSON) {
                            continue;
                        } else {
                            MayKnowRecommend e17 = cVar5.e();
                            if (e17 != null) {
                                str = e17.uin;
                            } else {
                                str = null;
                            }
                            if (Intrinsics.areEqual(str, e16.uin)) {
                                break;
                            } else {
                                i16++;
                            }
                        }
                    }
                }
                a.d(oVar4, e16, i16);
            }
            ((o) holder).y0(new Function2<String, AddContactDataType, Unit>(this) { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.AddContactListAdapterV2$onBindViewHolder$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ AddContactListAdapterV2 this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecyclerView.ViewHolder.this, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str11, AddContactDataType addContactDataType) {
                    invoke2(str11, addContactDataType);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull String id5, @NotNull AddContactDataType type) {
                    Function2 function2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) id5, (Object) type);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(id5, "id");
                    Intrinsics.checkNotNullParameter(type, "type");
                    View view = RecyclerView.ViewHolder.this.itemView;
                    AddContactSwipeMenuLayout addContactSwipeMenuLayout = view instanceof AddContactSwipeMenuLayout ? (AddContactSwipeMenuLayout) view : null;
                    if (addContactSwipeMenuLayout != null) {
                        addContactSwipeMenuLayout.k();
                    }
                    function2 = this.this$0.dislikeItemListener;
                    function2.invoke(id5, type);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RecyclerView.ViewHolder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (viewType != 1) {
            if (viewType != 2) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.gvd, parent, false);
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                o oVar = new o(itemView);
                itemView.setTag(oVar);
                return oVar;
            }
            c cVar = c.f180933a;
            Context context = parent.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "parent.context");
            return new p(cVar.b(context));
        }
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.gvf, parent, false);
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        return new r(itemView2, null);
    }
}
