package com.tencent.mobileqq.guild.setting.guildmanage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.c;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002 !B\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u001a\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nJ\u0006\u0010\r\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/v;", "Landroid/app/Dialog;", "", "initWindow", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", BdhLogUtil.LogTag.Tag_Req, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "groupPosition", "Lcom/tencent/mobileqq/widget/listitem/w;", "extConfig", "X", "W", "Lcom/tencent/mobileqq/guild/setting/guildmanage/v$d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/setting/guildmanage/v$d;", "callback", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "E", "[Lcom/tencent/mobileqq/widget/listitem/Group;", "configItems", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/setting/guildmanage/v$d;)V", UserInfo.SEX_FEMALE, "c", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class v extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final d callback;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Group[] configItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/v$a", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f234386d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ v f234387e;

        a(Context context, v vVar) {
            this.f234386d = context;
            this.f234387e = vVar;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @NotNull
        /* renamed from: createContentView */
        public View getF57419d() {
            View rootView = LayoutInflater.from(this.f234386d).inflate(R.layout.f1v, (ViewGroup) null);
            QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) rootView.findViewById(R.id.f238007e);
            if (qUISettingsRecyclerView != null) {
                this.f234387e.R(qUISettingsRecyclerView);
            }
            Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
            return rootView;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/v$d;", "", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface d {
        @NotNull
        Group[] a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(@NotNull Context context, @NotNull d callback) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
        initWindow();
        setContentView(R.layout.ejv);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById(R.id.f66733bf);
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.J();
            qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
            qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: cz1.bm
                @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
                public final void onDismiss() {
                    com.tencent.mobileqq.guild.setting.guildmanage.v.U(com.tencent.mobileqq.guild.setting.guildmanage.v.this);
                }
            });
            qUSHalfScreenFloatingView.setQUSDragFloatController(new a(context, this));
            qUSHalfScreenFloatingView.j(new b(qUSHalfScreenFloatingView));
        } else {
            qUSHalfScreenFloatingView = null;
        }
        this.floatingView = qUSHalfScreenFloatingView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(RecyclerView recyclerView) {
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        recyclerView.setAdapter(qUIListItemAdapter);
        this.configItems = this.callback.a();
        Group[] a16 = this.callback.a();
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(a16, a16.length));
        qUIListItemAdapter.notifyDataSetChanged();
        recyclerView.setOnClickListener(new View.OnClickListener() { // from class: cz1.bl
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                com.tencent.mobileqq.guild.setting.guildmanage.v.S(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(v this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void initWindow() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QQGuildPermissionDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    public final void Q() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.floatingView;
        if (qUSHalfScreenFloatingView != null) {
            qUSHalfScreenFloatingView.t();
        }
    }

    public final void W() {
        RecyclerView recyclerView;
        RecyclerView.Adapter adapter;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.floatingView;
        if (qUSHalfScreenFloatingView != null && (recyclerView = (RecyclerView) qUSHalfScreenFloatingView.findViewById(R.id.f238007e)) != null && (adapter = recyclerView.getAdapter()) != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public final void X(int groupPosition, @NotNull w<?> extConfig) {
        Group group;
        ArrayList<com.tencent.mobileqq.widget.listitem.a<?>> a16;
        Intrinsics.checkNotNullParameter(extConfig, "extConfig");
        Group[] groupArr = this.configItems;
        if (groupArr != null && (group = groupArr[groupPosition]) != null && (a16 = group.a()) != null) {
            ArrayList<com.tencent.mobileqq.widget.listitem.a> arrayList = new ArrayList();
            for (Object obj : a16) {
                if (!Intrinsics.areEqual((com.tencent.mobileqq.widget.listitem.a) obj, extConfig)) {
                    arrayList.add(obj);
                }
            }
            for (com.tencent.mobileqq.widget.listitem.a aVar : arrayList) {
                x.c.i iVar = null;
                c.b.d dVar = null;
                if (aVar instanceof x) {
                    x.c O = ((x) aVar).O();
                    if (O instanceof x.c.i) {
                        iVar = (x.c.i) O;
                    }
                    if (iVar != null) {
                        iVar.f(false);
                    }
                } else if (aVar instanceof com.tencent.mobileqq.widget.listitem.c) {
                    c.b O2 = ((com.tencent.mobileqq.widget.listitem.c) aVar).O();
                    if (O2 instanceof c.b.d) {
                        dVar = (c.b.d) O2;
                    }
                    if (dVar != null) {
                        dVar.e(false);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/v$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$p;", "", "onShowTotalStart", "onShowTotal", "onShowDefaultStart", "onShowDefault", "onShowMinStart", "onShowMin", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.p {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f234389e;

        b(QUSHalfScreenFloatingView qUSHalfScreenFloatingView) {
            this.f234389e = qUSHalfScreenFloatingView;
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotal() {
            QUIImmersiveHelper.t(v.this.getWindow(), false, null, true, this.f234389e);
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefault() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowDefaultStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMin() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowMinStart() {
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.p
        public void onShowTotalStart() {
        }
    }
}
