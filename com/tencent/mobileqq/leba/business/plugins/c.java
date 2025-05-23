package com.tencent.mobileqq.leba.business.plugins;

import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTypeInfo;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.tianshu.ui.TianshuRedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneActiveRedCountInfoApi;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQzoneQcircleRedDotApi;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002Jb\u0010\u001e\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016Jb\u0010\u001f\u001a\u00020\u001c2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0016J \u0010'\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016R\u0014\u0010+\u001a\u00020\u00148VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/c;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/tianshu/ui/TianshuRedTouch;", "redTouch", "", "Y", "", "count", "W", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Z", "T", "U", "Lcom/tencent/mobileqq/servlet/QZoneManagerImp;", "qim", "V", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "", "resID", "", "resPkgName", "", "Lcom/tencent/mobileqq/leba/entity/g;", "redTouchHistory", "index", "", "isTableModel", "y", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "Lcom/tencent/mobileqq/redtouch/RedTypeInfo;", "w", "()J", "resId", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c extends BaseLebaPluginItem {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/leba/business/plugins/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.leba.business.plugins.c$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58565);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final int T() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return 0;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.QZoneManagerImp");
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) manager;
        int j3 = qZoneManagerImp.j(1) + qZoneManagerImp.j(73);
        if (QZoneIntimateEntranceManager.u()) {
            QLog.i("LebaQzonePlugin", 4, "is frame moment switch open, show moment passive dot");
            j3 += qZoneManagerImp.j(66);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + qZoneManagerImp.j(1));
        }
        return j3;
    }

    private final int U() {
        QQAppInterface qQAppInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return 0;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.QZONE_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.servlet.QZoneManagerImp");
        QZoneManagerImp qZoneManagerImp = (QZoneManagerImp) manager;
        int j3 = qZoneManagerImp.j(2) + qZoneManagerImp.j(3) + qZoneManagerImp.j(1027);
        if (QZoneIntimateEntranceManager.u()) {
            QLog.i("LebaQzonePlugin", 4, "is frame moment switch open, show moment active dot");
            j3 += qZoneManagerImp.j(67);
        }
        if (!SimpleUIUtil.isNowElderMode()) {
            j3 += V(qZoneManagerImp);
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + qZoneManagerImp.j(2) + " TYPE_VISITOR:" + qZoneManagerImp.j(3) + " TYPE INTIMATE: " + qZoneManagerImp.j(74));
        }
        QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + j3);
        return j3;
    }

    private final int V(QZoneManagerImp qim) {
        if (qim == null) {
            return 0;
        }
        int j3 = qim.j(74);
        QZoneCountInfo k3 = qim.k(74);
        if (j3 > 0 && k3 != null) {
            ((IQZoneActiveRedCountInfoApi) QRoute.api(IQZoneActiveRedCountInfoApi.class)).saveRedCountInfo(74, k3);
        }
        QLog.i("LebaQzonePlugin", 4, "intimateUnreadCnt is " + j3);
        return j3;
    }

    private final void W(final int count, final TianshuRedTouch redTouch) {
        QLog.i("LebaSpecificRedTouchBiz", 1, "showRedDotView unReadCount= " + count);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.b
            @Override // java.lang.Runnable
            public final void run() {
                c.X(count, redTouch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(int i3, TianshuRedTouch redTouch) {
        Intrinsics.checkNotNullParameter(redTouch, "$redTouch");
        if (i3 <= 0) {
            redTouch.w();
            return;
        }
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo.red_type.set(0);
        redTypeInfo.red_content.set("");
        redTypeInfo.red_desc.set("");
        redTouch.B0(redTypeInfo);
    }

    private final void Y(TianshuRedTouch redTouch) {
        int qZoneUnReadCount;
        if (redTouch == null) {
            return;
        }
        boolean showAlbumEntranceRedDot = ((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).showAlbumEntranceRedDot();
        if (showAlbumEntranceRedDot) {
            if (!com.tencent.mobileqq.leba.utils.a.f240765a.b()) {
                ((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).showAlbumEntranceGuideBubble(o(), true);
            }
            qZoneUnReadCount = 1;
        } else {
            qZoneUnReadCount = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getQZoneUnReadCount(19);
        }
        QLog.i(((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).getPrefixLogTag() + "LebaPluginAlbum", 1, "updateAlbumRedBadge, showAlbumEntranceRedDot=" + showAlbumEntranceRedDot + ", count= " + qZoneUnReadCount);
        W(qZoneUnReadCount, redTouch);
    }

    private final void Z(final RedTouch redTouch) {
        if (redTouch == null) {
            return;
        }
        final int qZoneUnReadCount = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getQZoneUnReadCount(19);
        QLog.i("LebaSpecificRedTouchBiz", 1, "updateAlbumRedTouch unReadCount= " + qZoneUnReadCount);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.plugins.a
            @Override // java.lang.Runnable
            public final void run() {
                c.a0(qZoneUnReadCount, redTouch);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(int i3, RedTouch redTouch) {
        if (i3 <= 0) {
            redTouch.clearRedTouch();
            return;
        }
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo.red_type.set(0);
        redTypeInfo.red_content.set("");
        redTypeInfo.red_desc.set("");
        redTouch.parseRedTouch(redTypeInfo);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(@NotNull View v3, @NotNull com.tencent.mobileqq.leba.entity.n item, @NotNull com.tencent.mobileqq.leba.entity.f reportInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, v3, item, reportInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        super.H(v3, item, reportInfo);
        boolean showAlbumEntranceRedDot = ((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).showAlbumEntranceRedDot();
        QLog.i(((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).getPrefixLogTag() + "LebaPluginAlbum", 1, "onPluginClick, showAlbumEntranceRedDot=" + showAlbumEntranceRedDot);
        if (showAlbumEntranceRedDot) {
            ((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).saveAlbumEntranceRedDotVisible(false);
        }
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return 785L;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    @Nullable
    public RedTypeInfo w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RedTypeInfo) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int T = T();
        int U = U();
        LebaTabRedTouch.e(T, U);
        if (T > 0) {
            RedTypeInfo redTypeInfo = new RedTypeInfo();
            redTypeInfo.setRedType(5);
            redTypeInfo.setRedContent(String.valueOf(T));
            return redTypeInfo;
        }
        if (U > 0) {
            RedTypeInfo redTypeInfo2 = new RedTypeInfo();
            redTypeInfo2.setRedType(0);
            return redTypeInfo2;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean x(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable TianshuRedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        Y(redTouch);
        return true;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean y(@Nullable AppRuntime app, @Nullable Context context, long resID, @Nullable RedTouch redTouch, @Nullable String resPkgName, @Nullable Map<Long, ? extends com.tencent.mobileqq.leba.entity.g> redTouchHistory, int index, boolean isTableModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, app, context, Long.valueOf(resID), redTouch, resPkgName, redTouchHistory, Integer.valueOf(index), Boolean.valueOf(isTableModel))).booleanValue();
        }
        Z(redTouch);
        return true;
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return ((IQzoneQcircleRedDotApi) QRoute.api(IQzoneQcircleRedDotApi.class)).showAlbumEntranceRedDot();
    }
}
