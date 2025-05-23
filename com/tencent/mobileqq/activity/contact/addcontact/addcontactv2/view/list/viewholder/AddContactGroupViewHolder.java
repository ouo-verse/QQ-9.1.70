package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.AddContactReportHelper;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.swipe.AddContactSwipeMenuLayout;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.troop.flock.QeventPB$Feed;
import tencent.im.troop.flock.QeventPB$User;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001Bz\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001e\u0012:\u0010+\u001a6\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00160\"j\u0002`(\u0012%\u00100\u001a!\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00160,j\u0002`-\u00a2\u0006\u0004\b;\u0010<J\u001a\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010\u000b\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000e\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 RH\u0010+\u001a6\u0012\u0013\u0012\u00110\u001e\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00160\"j\u0002`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R3\u00100\u001a!\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0004\u0012\u00020\u00160,j\u0002`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0017\u0010:\u001a\u0002058\u0006\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/AddContactGroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/c;", "Lcom/tencent/mobileqq/troop/recommend/data/RecommendTroopItem;", "troop", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/data/MayKnowRecommend;", "person", "p", "o", "Ltencent/im/troop/flock/QeventPB$Feed;", "feed", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/b;", "groupData", "position", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/a;", "avatarDelegate", "Lcom/tencent/mobileqq/app/MayknowRecommendManager;", "mayKnowManager", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "recommendTraceId", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "id", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "type", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/DislikeRecommendItemListener;", "G", "Lkotlin/jvm/functions/Function2;", "dislikeItemListener", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/MoreViewItemListener;", "H", "Lkotlin/jvm/functions/Function1;", "moreViewClickListener", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/r;", "I", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/r;", "titleViewHolder", "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "r", "()Landroid/widget/LinearLayout;", "contentLayout", "<init>", "(Landroid/view/View;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AddContactGroupViewHolder extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String recommendTraceId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Function2<String, AddContactDataType, Unit> dislikeItemListener;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Function1<AddContactDataType, Unit> moreViewClickListener;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final r titleViewHolder;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout contentLayout;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180934a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50157);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[AddContactDataType.values().length];
            try {
                iArr[AddContactDataType.f293812GROUP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AddContactDataType.PERSON.ordinal()] = 2;
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
            f180934a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddContactGroupViewHolder(@NotNull View itemView, @NotNull String recommendTraceId, @NotNull Function2<? super String, ? super AddContactDataType, Unit> dislikeItemListener, @NotNull Function1<? super AddContactDataType, Unit> moreViewClickListener) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(recommendTraceId, "recommendTraceId");
        Intrinsics.checkNotNullParameter(dislikeItemListener, "dislikeItemListener");
        Intrinsics.checkNotNullParameter(moreViewClickListener, "moreViewClickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, itemView, recommendTraceId, dislikeItemListener, moreViewClickListener);
            return;
        }
        this.itemView = itemView;
        this.recommendTraceId = recommendTraceId;
        this.dislikeItemListener = dislikeItemListener;
        this.moreViewClickListener = moreViewClickListener;
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        this.titleViewHolder = new r(itemView2, moreViewClickListener);
        View findViewById = this.itemView.findViewById(R.id.vtk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.group_content_layout)");
        this.contentLayout = (LinearLayout) findViewById;
    }

    private final int n(List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list, QeventPB$Feed qeventPB$Feed) {
        String str;
        PBStringField pBStringField;
        int i3 = 1;
        for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : list) {
            if (cVar.c() == AddContactDataType.FLOCK) {
                QeventPB$Feed d16 = cVar.d();
                if (d16 != null && (pBStringField = d16.f436058id) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, qeventPB$Feed.f436058id.get())) {
                    break;
                }
                i3++;
            }
        }
        return i3;
    }

    private final int o(List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list, RecommendTroopItem recommendTroopItem) {
        int i3 = 1;
        for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : list) {
            if (cVar.c() == AddContactDataType.GUILD) {
                RecommendTroopItem f16 = cVar.f();
                boolean z16 = false;
                if (f16 != null && f16.getId() == recommendTroopItem.getId()) {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
                i3++;
            }
        }
        return i3;
    }

    private final int p(List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list, MayKnowRecommend mayKnowRecommend) {
        String str;
        int i3 = 1;
        for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : list) {
            if (cVar.c() == AddContactDataType.PERSON) {
                MayKnowRecommend e16 = cVar.e();
                if (e16 != null) {
                    str = e16.uin;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, mayKnowRecommend.uin)) {
                    break;
                }
                i3++;
            }
        }
        return i3;
    }

    private final int q(List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> list, RecommendTroopItem recommendTroopItem) {
        int i3 = 1;
        for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : list) {
            if (cVar.c() == AddContactDataType.f293812GROUP) {
                RecommendTroopItem f16 = cVar.f();
                boolean z16 = false;
                if (f16 != null && f16.getId() == recommendTroopItem.getId()) {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
                i3++;
            }
        }
        return i3;
    }

    public final void m(@NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.b groupData, int position, @NotNull com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel.a avatarDelegate, @NotNull MayknowRecommendManager mayKnowManager) {
        Map<String, String> mapOf;
        QeventPB$Feed d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, groupData, Integer.valueOf(position), avatarDelegate, mayKnowManager);
            return;
        }
        Intrinsics.checkNotNullParameter(groupData, "groupData");
        Intrinsics.checkNotNullParameter(avatarDelegate, "avatarDelegate");
        Intrinsics.checkNotNullParameter(mayKnowManager, "mayKnowManager");
        this.titleViewHolder.m(groupData.b(), position);
        this.contentLayout.removeAllViews();
        for (com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c cVar : groupData.a()) {
            final View itemView = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.gvd, (ViewGroup) null, false);
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            o oVar = new o(itemView);
            itemView.setTag(oVar);
            int i16 = a.f180934a[cVar.c().ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != i3) {
                        if (i16 == 4 && (d16 = cVar.d()) != null) {
                            QeventPB$User qeventPB$User = d16.publisher.get();
                            String str = qeventPB$User.f436060id.get();
                            Intrinsics.checkNotNullExpressionValue(str, "personItem.id.get()");
                            oVar.x0(avatarDelegate.c(str, 1));
                            String str2 = qeventPB$User.f436060id.get();
                            Intrinsics.checkNotNullExpressionValue(str2, "personItem.id.get()");
                            Bitmap b16 = avatarDelegate.b(str2, 1);
                            Context context = oVar.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context, "contentVH.itemView.context");
                            oVar.E(d16, avatarDelegate.f(context), b16);
                            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.a.a(oVar, d16, n(groupData.a(), d16));
                        }
                    } else {
                        RecommendTroopItem f16 = cVar.f();
                        if (f16 != null) {
                            Context context2 = itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
                            String str3 = f16.icon;
                            Intrinsics.checkNotNullExpressionValue(str3, "it.icon");
                            oVar.W(f16, avatarDelegate.h(context2, str3));
                            com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.a.c(oVar, f16, o(groupData.a(), f16));
                        }
                    }
                } else {
                    MayKnowRecommend e16 = cVar.e();
                    if (e16 != null) {
                        String str4 = e16.uin;
                        Intrinsics.checkNotNullExpressionValue(str4, "it.uin");
                        oVar.w0(avatarDelegate.c(str4, 1));
                        String str5 = e16.uin;
                        Intrinsics.checkNotNullExpressionValue(str5, "it.uin");
                        oVar.c0(cVar, avatarDelegate.b(str5, 1), position, mayKnowManager);
                        com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.a.d(oVar, e16, p(groupData.a(), e16));
                    }
                }
            } else {
                RecommendTroopItem f17 = cVar.f();
                if (f17 != null) {
                    String str6 = f17.uin;
                    Intrinsics.checkNotNullExpressionValue(str6, "it.uin");
                    oVar.P(cVar, avatarDelegate.g(str6));
                    com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.a.b(oVar, f17, cVar.d(), q(groupData.a(), f17));
                }
            }
            oVar.y0(new Function2<String, AddContactDataType, Unit>(itemView, this) { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.AddContactGroupViewHolder$bindView$1$5
                static IPatchRedirector $redirector_;
                final /* synthetic */ View $itemView;
                final /* synthetic */ AddContactGroupViewHolder this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$itemView = itemView;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) itemView, (Object) this);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str7, AddContactDataType addContactDataType) {
                    invoke2(str7, addContactDataType);
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
                    View view = this.$itemView;
                    AddContactSwipeMenuLayout addContactSwipeMenuLayout = view instanceof AddContactSwipeMenuLayout ? (AddContactSwipeMenuLayout) view : null;
                    if (addContactSwipeMenuLayout != null) {
                        addContactSwipeMenuLayout.k();
                    }
                    function2 = this.this$0.dislikeItemListener;
                    function2.invoke(id5, type);
                }
            });
            this.contentLayout.addView(itemView);
            i3 = 3;
        }
        AddContactDataType b17 = groupData.b().b();
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        View itemView2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("trace_id", this.recommendTraceId));
        addContactReportHelper.c(itemView2, addContactReportHelper.o(b17), b17 + "_" + position, mapOf);
    }

    @NotNull
    public final LinearLayout r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LinearLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.contentLayout;
    }
}
