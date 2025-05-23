package com.tencent.mobileqq.leba.entity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.ILebaPlugin;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b%\b&\u0018\u0000 J2\u00020\u0001:\u0001hB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\"\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016Jb\u0010-\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010'\u001a\u0004\u0018\u00010&2\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0011H\u0016Jb\u0010/\u001a\u00020\u00112\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010%\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010&2\u0018\u0010*\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\u0011H\u0016J\b\u00100\u001a\u00020\u0011H\u0016J\n\u00101\u001a\u0004\u0018\u00010&H\u0016J\n\u00103\u001a\u0004\u0018\u000102H\u0016J\n\u00105\u001a\u0004\u0018\u000104H\u0016J\u0018\u00107\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020&08H\u0016J\b\u0010:\u001a\u00020&H\u0016J\u0018\u0010<\u001a\u00020\u00022\u0006\u0010;\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010=\u001a\u00020\u0002H\u0016J\"\u0010A\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010>\u001a\u00020\u00042\b\b\u0002\u0010@\u001a\u00020?H\u0004J\u001a\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0004J\u000e\u0010F\u001a\u00020\u00022\u0006\u0010E\u001a\u00020DJ\u0006\u0010G\u001a\u00020\u0002J\u0016\u0010J\u001a\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010I\u001a\u00020\u0004J\u0006\u0010K\u001a\u00020\u0002J\u0006\u0010L\u001a\u00020\u0002J\u0006\u0010M\u001a\u00020\u0002J\u0006\u0010N\u001a\u00020\u0002R$\u0010U\u001a\u0004\u0018\u00010\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR$\u0010I\u001a\u0004\u0018\u00010\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010`\u001a\u0004\u0018\u00010D8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001b\u0010d\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010a\u001a\u0004\bb\u0010cR\u0014\u0010B\u001a\u00020$8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010e\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "", "", "K", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, tl.h.F, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "k", "E", "e", "G", "", "tabChange", "", "style", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "M", UserInfo.SEX_FEMALE, "D", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "appInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "resID", "", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "isTableModel", "y", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "u", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "Lcom/tencent/mobileqq/leba/entity/o;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mode", "l", "", ReportConstant.COSTREPORT_PREFIX, "t", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "N", "J", "redPointSubView", "Landroid/widget/RelativeLayout$LayoutParams;", "params", "f", "resId", "L", "Lcom/tencent/mobileqq/leba/widget/a;", "controller", "j", "O", "lebaViewItem", "itemView", "i", "P", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, BdhLogUtil.LogTag.Tag_Conn, "B", "d", "Lcom/tencent/mobileqq/leba/entity/n;", "r", "()Lcom/tencent/mobileqq/leba/entity/n;", "setPluginViewItem", "(Lcom/tencent/mobileqq/leba/entity/n;)V", "pluginViewItem", "Landroid/view/View;", "o", "()Landroid/view/View;", "setItemView", "(Landroid/view/View;)V", "Lcom/tencent/mobileqq/leba/widget/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/mobileqq/leba/widget/a;", "setPluginViewController", "(Lcom/tencent/mobileqq/leba/widget/a;)V", "pluginViewController", "Lkotlin/Lazy;", "p", "()Lcom/tencent/mobileqq/leba/entity/DefaultClickProcessor;", "pluginItemClickProcessor", "()J", "<init>", "()V", "a", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Lazy<ILebaPlugin> f240426m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private n pluginViewItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View itemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.leba.widget.a pluginViewController;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pluginItemClickProcessor;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem$a;", "", "", "JUMP_TYPE_MINI_APP", ExifInterface.LATITUDE_SOUTH, "JUMP_TYPE_WEB", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqleba-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.entity.BaseLebaPluginItem$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        Lazy<ILebaPlugin> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 44)) {
            redirector.redirect((short) 44);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(BaseLebaPluginItem$Companion$lebaPluginApi$2.INSTANCE);
        f240426m = lazy;
    }

    public BaseLebaPluginItem() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<DefaultClickProcessor>() { // from class: com.tencent.mobileqq.leba.entity.BaseLebaPluginItem$pluginItemClickProcessor$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BaseLebaPluginItem.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final DefaultClickProcessor invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? BaseLebaPluginItem.this.k() : (DefaultClickProcessor) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.pluginItemClickProcessor = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void K() {
        ((ILebaPlugin) QRoute.api(ILebaPlugin.class)).perParseDns(s(), t());
    }

    public static /* synthetic */ void g(BaseLebaPluginItem baseLebaPluginItem, RedTouch redTouch, View view, RelativeLayout.LayoutParams layoutParams, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            }
            baseLebaPluginItem.f(redTouch, view, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRedPointView");
    }

    private final DefaultClickProcessor p() {
        return (DefaultClickProcessor) this.pluginItemClickProcessor.getValue();
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
            return;
        }
        com.tencent.mobileqq.leba.widget.a aVar = this.pluginViewController;
        if (aVar != null) {
            aVar.c(this.pluginViewItem);
        }
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        QLog.i("BaseLebaPluginItem", 1, "notifyPluginPerformClick pluginId: " + v());
        View view = this.itemView;
        if (view != null) {
            view.performClick();
        }
    }

    public final void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this);
            return;
        }
        QLog.i("BaseLebaPluginItem", 1, "notifyPluginViewRefresh pluginId: " + v());
        com.tencent.mobileqq.leba.widget.a aVar = this.pluginViewController;
        if (aVar != null) {
            aVar.a(v());
        }
    }

    public void D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }

    public void H(@NotNull View v3, @NotNull n item, @NotNull f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        p().i(v3, item, reportInfo);
    }

    public void I(boolean tabChange, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(tabChange), Integer.valueOf(style));
        } else {
            K();
        }
    }

    public void J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L(long resId, @Nullable RedTouch redTouch) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Long.valueOf(resId), redTouch);
        }
    }

    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    public void N(boolean isOpen, @NotNull n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, Boolean.valueOf(isOpen), item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    public final void O() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            this.pluginViewController = null;
        }
    }

    public final void P() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        this.pluginViewItem = null;
        this.itemView = null;
        J();
    }

    public boolean Q(@NotNull RedTouch redTouch, @Nullable BusinessInfoCheckUpdate.AppInfo appInfo, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, redTouch, appInfo, Integer.valueOf(style))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        return false;
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        }
    }

    protected final void f(@NotNull RedTouch redTouch, @NotNull View redPointSubView, @NotNull RelativeLayout.LayoutParams params) {
        RelativeLayout relativeLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, redTouch, redPointSubView, params);
            return;
        }
        Intrinsics.checkNotNullParameter(redTouch, "redTouch");
        Intrinsics.checkNotNullParameter(redPointSubView, "redPointSubView");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            View target = redTouch.getTarget();
            ViewGroup viewGroup = null;
            if (target != null) {
                relativeLayout = (RelativeLayout) target.findViewById(R.id.yhr);
            } else {
                relativeLayout = null;
            }
            if (relativeLayout == null || Intrinsics.areEqual(redPointSubView.getParent(), relativeLayout)) {
                return;
            }
            ViewParent parent = redPointSubView.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup = (ViewGroup) parent;
            }
            if (viewGroup != null) {
                viewGroup.removeView(redPointSubView);
            }
            relativeLayout.removeAllViews();
            relativeLayout.addView(redPointSubView, params);
        } catch (Exception e16) {
            QLog.e("BaseLebaPluginItem", 1, "addRedPointView catch exception: ", e16);
        }
    }

    public void h(@NotNull View v3, @Nullable n item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
        }
    }

    public final void i(@NotNull n lebaViewItem, @NotNull View itemView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) lebaViewItem, (Object) itemView);
            return;
        }
        Intrinsics.checkNotNullParameter(lebaViewItem, "lebaViewItem");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.pluginViewItem = lebaViewItem;
        this.itemView = itemView;
    }

    public final void j(@NotNull com.tencent.mobileqq.leba.widget.a controller) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) controller);
        } else {
            Intrinsics.checkNotNullParameter(controller, "controller");
            this.pluginViewController = controller;
        }
    }

    @NotNull
    public DefaultClickProcessor k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (DefaultClickProcessor) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new DefaultClickProcessor();
    }

    public boolean l(int mode, int style) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 29, this, Integer.valueOf(mode), Integer.valueOf(style))).booleanValue();
    }

    @Nullable
    public o m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (o) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return null;
    }

    @Nullable
    public final BusinessInfoCheckUpdate.AppInfo n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (BusinessInfoCheckUpdate.AppInfo) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        return ((IRedTouchManager) runtimeService).getAppInfoByPath(String.valueOf(v()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final View o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.itemView;
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final com.tencent.mobileqq.leba.widget.a q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.leba.widget.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.pluginViewController;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final n r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (n) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pluginViewItem;
    }

    @NotNull
    public List<String> s() {
        List<String> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 31)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 31, (Object) this);
    }

    @NotNull
    public String t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (String) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return "";
    }

    @Nullable
    public String u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return null;
    }

    public abstract long v();

    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return null;
    }

    public boolean x(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable TianshuRedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 23, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
    }

    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 22, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
    }

    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        return false;
    }
}
