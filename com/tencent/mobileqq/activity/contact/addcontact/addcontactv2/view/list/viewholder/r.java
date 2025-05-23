package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.report.AddContactReportHelper;
import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.AddContactMoreFragment;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.addcontact.model.AddContactDataType;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.troop.flock.QeventPB$Feed;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B<\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012+\b\u0002\u0010\u0013\u001a%\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\fj\u0004\u0018\u0001`\u0010\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR7\u0010\u0013\u001a%\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\fj\u0004\u0018\u0001`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/view/list/viewholder/r;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/troop/addcontact/model/AddContactDataType;", "dataType", "", "o", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/e;", "data", "", "position", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "type", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/MoreViewItemListener;", "E", "Lkotlin/jvm/functions/Function1;", "onMoreItemClickListener", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "titleView", "Landroid/widget/LinearLayout;", "G", "Landroid/widget/LinearLayout;", "moreArea", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class r extends RecyclerView.ViewHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Function1<AddContactDataType, Unit> onMoreItemClickListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView titleView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout moreArea;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f180968a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50160);
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
            f180968a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public r(@NotNull View itemView, @Nullable Function1<? super AddContactDataType, Unit> function1) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) function1);
            return;
        }
        this.onMoreItemClickListener = function1;
        View findViewById = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.title)");
        this.titleView = (TextView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zec);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.more_area)");
        this.moreArea = (LinearLayout) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(r this$0, com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.e data, View view) {
        y45.b bVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Function1<AddContactDataType, Unit> function1 = this$0.onMoreItemClickListener;
        if (function1 != null) {
            function1.invoke(data.b());
        }
        if (data.b() == AddContactDataType.FLOCK) {
            List<com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c> c16 = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.repository.a.f180891a.c(data.b());
            IFlockLauncher iFlockLauncher = (IFlockLauncher) QRoute.api(IFlockLauncher.class);
            Context context = this$0.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                QeventPB$Feed d16 = ((com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.c) it.next()).d();
                if (d16 != null) {
                    bVar = com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.a.f180863a.b(d16);
                } else {
                    bVar = null;
                }
                if (bVar != null) {
                    arrayList.add(bVar);
                }
            }
            iFlockLauncher.launchSearchRecomFeedListPage(context, arrayList, FlockConstants$FlockListScene.RECOM);
        } else {
            AddContactMoreFragment.Companion companion = AddContactMoreFragment.INSTANCE;
            Context context2 = this$0.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "itemView.context");
            companion.a(context2, data.b(), this$0.titleView.getText().toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final String o(AddContactDataType dataType) {
        int i3 = a.f180968a[dataType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        String string = this.itemView.getContext().getString(R.string.yk8);
                        Intrinsics.checkNotNullExpressionValue(string, "itemView.context.getStri\u2026ntacts_may_interest_pair)");
                        return string;
                    }
                    throw new NoWhenBranchMatchedException();
                }
                String string2 = this.itemView.getContext().getString(R.string.yk7);
                Intrinsics.checkNotNullExpressionValue(string2, "itemView.context.getStri\u2026tacts_may_interest_guild)");
                return string2;
            }
            String string3 = this.itemView.getContext().getString(R.string.yk9);
            Intrinsics.checkNotNullExpressionValue(string3, "itemView.context.getStri\u2026acts_may_interest_person)");
            return string3;
        }
        String string4 = this.itemView.getContext().getString(R.string.yk6);
        Intrinsics.checkNotNullExpressionValue(string4, "itemView.context.getStri\u2026tacts_may_interest_group)");
        return string4;
    }

    public final void m(@NotNull final com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.e data, int position) {
        boolean isBlank;
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) data, position);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        TextView textView = this.titleView;
        String c16 = data.c();
        isBlank = StringsKt__StringsJVMKt.isBlank(c16);
        if (isBlank) {
            c16 = o(data.b());
        }
        textView.setText(c16);
        this.moreArea.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.view.list.viewholder.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.n(r.this, data, view);
            }
        });
        AddContactReportHelper addContactReportHelper = AddContactReportHelper.f180887a;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("module_name", String.valueOf(addContactReportHelper.p(data.b()))));
        addContactReportHelper.c(this.moreArea, "em_search_recommend_more_btn", "title|" + position, mapOf);
    }
}
