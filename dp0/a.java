package dp0;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.widget.qqui.QQViewPager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import fp0.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qo0.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0002\u001dCB\u0017\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u0010\u0010\u001a\u00020?\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001f\u0010\u0016\u001a\u00020\u00052\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\u0006\u0010!\u001a\u00020 H\u0014\u00a2\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R$\u0010>\u001a\u0002082\u0006\u00109\u001a\u0002088\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006D"}, d2 = {"Ldp0/a;", "Lcom/tencent/guild/aio/input/at/quickAt/dialogui/framework/a;", "Lcom/tencent/guild/aio/input/at/quickAt/dialogui/framework/GuildDialogGestureLayout$a;", "Lip0/b;", "T", "", "V", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "showListType", "W", "pageType", "", "Lcp0/a;", "newDataList", "X", "Lqo0/e;", "configuration", "Lro0/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "args", "j", "([Ljava/lang/Object;)V", "", HippyTKDListViewAdapter.X, "i", "deltaScrollY", "", "a", "isHalfMode", "y", "Landroid/content/Context;", "context", "Loo0/a;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Landroid/content/Context;)[Loo0/a;", "Lfp0/b;", "K", "Lfp0/b;", "panelStyle", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "L", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "panelContext", "Lep0/a;", "M", "Lep0/a;", "viewPagerAdapter", "Ljp0/a;", "N", "Ljp0/a;", "uiHelper", "P", "Lcp0/a;", "selectItem", "Lfp0/a;", "<set-?>", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfp0/a;", "U", "()Lfp0/a;", "notifier", "Lfp0/c;", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;Lfp0/c;)V", BdhLogUtil.LogTag.Tag_Req, "b", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class a extends com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a implements GuildDialogGestureLayout.a {

    /* renamed from: K, reason: from kotlin metadata */
    private b panelStyle;

    /* renamed from: L, reason: from kotlin metadata */
    private com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext;

    /* renamed from: M, reason: from kotlin metadata */
    private ep0.a viewPagerAdapter;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private jp0.a uiHelper;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private cp0.a selectItem;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private fp0.a notifier;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Ldp0/a$a;", "", "Ldp0/a;", "a", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;", "panelContext", "Lfp0/c;", "b", "Lfp0/c;", "configuration", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dp0.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C10196a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final fp0.c configuration;

        public C10196a(@NotNull com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext) {
            Intrinsics.checkNotNullParameter(panelContext, "panelContext");
            this.panelContext = panelContext;
            Context c16 = panelContext.c();
            Intrinsics.checkNotNullExpressionValue(c16, "panelContext.context");
            this.configuration = new fp0.c(c16);
        }

        @NotNull
        public final a a() {
            a aVar = new a(this.panelContext, this.configuration);
            aVar.z();
            return aVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a panelContext, @NotNull fp0.c configuration) {
        super(panelContext.c(), configuration, new Object[]{panelContext});
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.notifier = new fp0.a();
    }

    private final ip0.b T() {
        return new c();
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    @NotNull
    protected oo0.a[] A(@NotNull Context context) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        oo0.a[] aVarArr = new oo0.a[1];
        b bVar = this.panelStyle;
        ep0.a aVar = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelStyle");
            bVar = null;
        }
        aVarArr[0] = new gp0.a(context, bVar);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVarArr);
        com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a aVar2 = this.panelContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContext");
            aVar2 = null;
        }
        if (aVar2.j().size() > 1) {
            com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a aVar3 = this.panelContext;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContext");
                aVar3 = null;
            }
            b bVar2 = this.panelStyle;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelStyle");
                bVar2 = null;
            }
            arrayListOf.add(new gp0.c(aVar3, bVar2));
        }
        oo0.c cVar = new oo0.c(context);
        ep0.a aVar4 = this.viewPagerAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
        } else {
            aVar = aVar4;
        }
        cVar.t(aVar);
        arrayListOf.add(cVar);
        Object[] array = arrayListOf.toArray(new oo0.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (oo0.a[]) array;
    }

    @NotNull
    /* renamed from: U, reason: from getter */
    public final fp0.a getNotifier() {
        return this.notifier;
    }

    public final void V() {
        this.notifier.c(this.selectItem);
        this.selectItem = null;
    }

    public final void W(@NotNull HashTagPageType showListType) {
        Intrinsics.checkNotNullParameter(showListType, "showListType");
        QQViewPager s16 = ((oo0.c) l(oo0.c.class)).s();
        com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a aVar = this.panelContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContext");
            aVar = null;
        }
        int max = Math.max(0, aVar.j().indexOf(showListType));
        if (s16 != null) {
            s16.setCurrentItem(max);
        }
    }

    public final void X(@NotNull HashTagPageType pageType, @NotNull List<? extends cp0.a> newDataList) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(newDataList, "newDataList");
        ep0.a aVar = this.viewPagerAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
            aVar = null;
        }
        aVar.k(pageType, newDataList);
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.GuildDialogGestureLayout.a
    public boolean a(int deltaScrollY) {
        ep0.a aVar = this.viewPagerAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPagerAdapter");
            aVar = null;
        }
        if (!aVar.f(deltaScrollY, ((oo0.c) l(oo0.c.class)).q()) && deltaScrollY <= 0) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void i(@Nullable e configuration) {
        gp0.c cVar;
        QUIPageTabBar quiPageTabBar;
        super.i(configuration);
        this.F.setNestVerticalChild(this);
        this.F.setTargetView(((gp0.a) l(gp0.a.class)).c());
        oo0.c cVar2 = (oo0.c) l(oo0.c.class);
        com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a aVar = this.panelContext;
        b bVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContext");
            aVar = null;
        }
        if (aVar.j().size() > 1 && (cVar = (gp0.c) l(gp0.c.class)) != null && (quiPageTabBar = cVar.getQuiPageTabBar()) != null) {
            quiPageTabBar.setViewPager(cVar2.s());
        }
        cVar2.u(8);
        QQViewPager s16 = cVar2.s();
        b bVar2 = this.panelStyle;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelStyle");
        } else {
            bVar = bVar2;
        }
        s16.setBackgroundResource(bVar.getDrawable().getLittleTongueTitleBarBackground());
        setFocusable(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public void j(@NotNull Object[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        super.j(args);
        Object obj = args[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPanelContext");
        this.panelContext = (com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a) obj;
        b bVar = new b();
        Context mContext = this.f110977d;
        Intrinsics.checkNotNullExpressionValue(mContext, "mContext");
        bVar.c(mContext);
        this.panelStyle = bVar;
        com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a aVar = this.panelContext;
        b bVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContext");
            aVar = null;
        }
        b bVar3 = this.panelStyle;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelStyle");
        } else {
            bVar2 = bVar3;
        }
        this.viewPagerAdapter = new ep0.a(aVar, bVar2, T());
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    @NotNull
    protected ro0.c m(@NotNull e configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        b bVar = this.panelStyle;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelStyle");
            bVar = null;
        }
        jp0.a aVar = new jp0.a(configuration, bVar);
        this.uiHelper = aVar;
        Intrinsics.checkNotNull(aVar);
        return aVar;
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    protected int x() {
        b bVar = this.panelStyle;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelStyle");
            bVar = null;
        }
        return bVar.getDimen().getFullStatusTopPadding();
    }

    @Override // com.tencent.guild.aio.input.at.quickAt.dialogui.framework.a
    public int y(boolean isHalfMode) {
        return -1;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"dp0/a$c", "Lip0/b;", "", "i", "Lcp0/a;", "itemData", "U", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements ip0.b {
        c() {
        }

        @Override // ip0.b
        public void U(@NotNull cp0.a itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            a.this.selectItem = itemData;
            a.this.dismiss();
        }

        @Override // ip0.b
        public void i() {
        }
    }
}
