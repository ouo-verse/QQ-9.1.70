package ey1;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000K\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\"\u0018\u0000 *2\u00020\u0001:\u0001+B\u001d\u0012\u0006\u0010'\u001a\u00020&\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0012R\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u0012R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Ley1/d;", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "", "initUI", ExifInterface.LATITUDE_SOUTH, "Z", "Landroid/view/View$OnClickListener;", "listener", "W", "", "Ley1/e;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "getMemberList", "()Ljava/util/List;", "memberList", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "titleText", "E", "descText", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "memberListView", "Ley1/f;", "G", "Ley1/f;", "memberListAdapter", "H", "cancelBtn", "I", "addBtn", "ey1/d$c", "J", "Ley1/d$c;", "serviceObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class d extends QQCustomDialog {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<MemberData> memberList;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView titleText;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView descText;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView memberListView;

    /* renamed from: G, reason: from kotlin metadata */
    private f memberListAdapter;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView cancelBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView addBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final c serviceObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J(\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Ley1/d$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View$OnClickListener;", "confirmListener", "", "Ley1/e;", "memberList", "Ley1/d;", "a", "", "COLUMN", "I", "MAX_MEMBER_COUNT", "SPACING", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ey1.d$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final d a(@NotNull Context context, @NotNull View.OnClickListener confirmListener, @NotNull List<MemberData> memberList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(confirmListener, "confirmListener");
            Intrinsics.checkNotNullParameter(memberList, "memberList");
            if (memberList.isEmpty()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("showDialog but memberList is empty");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.RevokeRoleConfirmDialog", 1, (String) it.next(), null);
                }
                return null;
            }
            d dVar = new d(context, memberList);
            dVar.W(confirmListener);
            dVar.show();
            return dVar;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"ey1/d$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.left = (parent.getChildAdapterPosition(view) % 4) * 6;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"ey1/d$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "onUserDisplayNameUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            if (tinyId != null) {
                f fVar = d.this.memberListAdapter;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
                    fVar = null;
                }
                fVar.l0(tinyId);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull Context context, @NotNull List<MemberData> memberList) {
        super(context, R.style.qZoneInputDialog);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this.memberList = memberList;
        c cVar = new c();
        this.serviceObserver = cVar;
        initUI();
        S();
        Z();
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        final IGPSService iGPSService = (IGPSService) S0;
        Logger.f235387a.d().d("Guild.rg.RevokeRoleConfirmDialog", 1, "init addObserver service:" + System.identityHashCode(iGPSService));
        iGPSService.addObserver(cVar);
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: ey1.a
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                d.Q(IGPSService.this, this, dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(IGPSService service, d this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(service, "$service");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.rg.RevokeRoleConfirmDialog", 1, "setOnDismissListener deleteObserver service:" + System.identityHashCode(service));
        service.deleteObserver(this$0.serviceObserver);
    }

    private final void S() {
        RecyclerView recyclerView = this.memberListView;
        f fVar = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            recyclerView = null;
        }
        recyclerView.setOverScrollMode(2);
        RecyclerView recyclerView2 = this.memberListView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            recyclerView2 = null;
        }
        recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 4));
        RecyclerView recyclerView3 = this.memberListView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            recyclerView3 = null;
        }
        recyclerView3.addItemDecoration(new b());
        this.memberListAdapter = new f();
        RecyclerView recyclerView4 = this.memberListView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListView");
            recyclerView4 = null;
        }
        f fVar2 = this.memberListAdapter;
        if (fVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
        } else {
            fVar = fVar2;
        }
        recyclerView4.setAdapter(fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(View.OnClickListener listener, d this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        listener.onClick(view);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    @JvmStatic
    @Nullable
    public static final d Y(@NotNull Context context, @NotNull View.OnClickListener onClickListener, @NotNull List<MemberData> list) {
        return INSTANCE.a(context, onClickListener, list);
    }

    private final void Z() {
        f fVar = null;
        if (this.memberList.size() > 8) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 7; i3++) {
                arrayList.add(this.memberList.get(i3));
            }
            arrayList.add(new MemberData(null, null, 0, 3, null));
            f fVar2 = this.memberListAdapter;
            if (fVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
            } else {
                fVar = fVar2;
            }
            fVar.submitList(arrayList);
            return;
        }
        f fVar3 = this.memberListAdapter;
        if (fVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberListAdapter");
        } else {
            fVar = fVar3;
        }
        fVar.submitList(this.memberList);
    }

    private final void initUI() {
        TextView textView = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.f4k, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.title)");
        this.titleText = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.bg6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.desc)");
        this.descText = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.eoq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.member_list)");
        this.memberListView = (RecyclerView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.cancel)");
        this.cancelBtn = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.f163995gd);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.add)");
        this.addBtn = (TextView) findViewById5;
        TextView textView2 = this.descText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("descText");
            textView2 = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = getContext().getString(R.string.f153191bf);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_revoke_desc)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.memberList.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        textView2.setText(format);
        TextView textView3 = this.cancelBtn;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelBtn");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: ey1.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.U(d.this, view);
            }
        });
        setContentView(inflate);
    }

    public final void W(@NotNull final View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        TextView textView = this.addBtn;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addBtn");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: ey1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.X(listener, this, view);
            }
        });
    }
}
