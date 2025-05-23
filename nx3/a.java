package nx3;

import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b%\u0010&J(\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J<\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0006j\b\u0012\u0004\u0012\u00020\u0002`\u0007H\u0002J$\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J(\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J \u0010!\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J(\u0010$\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006'"}, d2 = {"Lnx3/a;", "Lcom/tencent/qqnt/aio/api/h;", "", "peerUid", "", "chatType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "l", "Lcom/tencent/mobileqq/tianshu/api/IRedTouchManager;", "redTouchManager", "appSet", "uin", "appRedIdList", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$RedTypeInfo;", "j", "redDotId", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "Landroid/view/View;", "target", "f", "redDot", "", "g", "i", "c", h.F, "", "d", "e", "b", AdMetricTag.Report.TYPE, "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.qqnt.aio.api.h {
    private final BusinessInfoCheckUpdate.RedTypeInfo j(IRedTouchManager redTouchManager, int appSet, String uin, ArrayList<String> appRedIdList) {
        return redTouchManager.getRedTouchInfoByAppSet(appSet, uin, appRedIdList);
    }

    private final ArrayList<String> l(String peerUid, int chatType) {
        ArrayList<String> redDotList = ((IPlusPanelApi) QRoute.api(IPlusPanelApi.class)).getRedDotList(peerUid, chatType);
        if (QLog.isColorLevel()) {
            QLog.i("RedDotInjector", 2, "red id list size: " + redDotList.size());
        }
        return redDotList;
    }

    private final IRedTouchManager m() {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        return (IRedTouchManager) runtimeService;
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void a(int reportType, String peerUid, int chatType, String redDotId) {
        BusinessInfoCheckUpdate.AppInfo k3;
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDotId, "redDotId");
        IRedTouchManager m3 = m();
        if (chatType != 1) {
            if (chatType == 2 && (k3 = k(m3, redDotId, peerUid)) != null) {
                m3.reportLevelOneRedInfo(k3.uiAppId.get(), reportType);
                return;
            }
            return;
        }
        BusinessInfoCheckUpdate.AppInfo k16 = k(m3, redDotId, null);
        if (k16 != null) {
            m3.reportLevelOneRedInfo(k16.uiAppId.get(), reportType);
        }
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void b(View redDot) {
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        RedTouch redTouch = redDot instanceof RedTouch ? (RedTouch) redDot : null;
        if (redTouch != null) {
            redTouch.clearRedTouch();
        }
        m().onRedTouchItemClick("130105");
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void c(String peerUid, int chatType, String redDotId, View redDot) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDotId, "redDotId");
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        if (peerUid.length() == 0) {
            return;
        }
        if (redDotId.length() == 0) {
            return;
        }
        IRedTouchManager m3 = m();
        if (chatType == 1) {
            ((RedTouch) redDot).parseRedTouch(k(m3, redDotId, null));
        } else {
            if (chatType != 2) {
                return;
            }
            ((RedTouch) redDot).parseRedTouch(k(m3, redDotId, peerUid));
        }
    }

    @Override // com.tencent.qqnt.aio.api.h
    public boolean d(View redDot) {
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        return (redDot instanceof RedTouch) && ((RedTouch) redDot).hasRedTouch();
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void e(String peerUid, int chatType, View redDot) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        IRedTouchManager m3 = m();
        if (chatType != 1) {
            if (chatType == 2 && !QQTheme.isNowSimpleUI()) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
                if (qQAppInterface != null ? m61.a.a(qQAppInterface) : false) {
                    QLog.d("RedDotInjector", 1, "EmoRedDot: Do not support Group right now");
                    return;
                } else {
                    QLog.d("RedDotInjector", 1, "EmoRedDot: needRed:false");
                    return;
                }
            }
            return;
        }
        BusinessInfoCheckUpdate.AppInfo appInfo = m3.getAppInfo(4, "130105");
        if (appInfo == null) {
            QLog.i("RedDotInjector", 1, "plus emo touch info: redTouchInfo==null");
            return;
        }
        QLog.i("RedDotInjector", 1, "plus emo touch info: redTouchInfo=" + appInfo);
        RedTouch redTouch = redDot instanceof RedTouch ? (RedTouch) redDot : null;
        if (redTouch != null) {
            redTouch.parseRedTouch(appInfo);
        }
        m3.reportLevelOneRedInfo("130105", 30);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public View f(Context context, View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        RedTouch redTouch = new RedTouch(context, target);
        redTouch.setGravity(8388661);
        redTouch.setRightMargin(15.0f);
        redTouch.setTopMargin(0.0f);
        redTouch.setLeftAlign(true);
        redTouch.applyTo();
        return redTouch;
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void g(String peerUid, int chatType, View redDot) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        IRedTouchManager m3 = m();
        ArrayList<String> l3 = l(peerUid, chatType);
        if (chatType == 1) {
            BusinessInfoCheckUpdate.RedTypeInfo j3 = j(m3, 10, null, l3);
            QLog.i("RedDotInjector", 1, "plus icon app info: " + j3);
            ((RedTouch) redDot).parseRedTouch(j3);
            m3.reportLevelZeroRedInfo(10, 30);
            return;
        }
        if (chatType != 2) {
            return;
        }
        BusinessInfoCheckUpdate.RedTypeInfo j16 = j(m3, 11, peerUid, l3);
        ((RedTouch) redDot).parseRedTouch(j16);
        QLog.i("RedDotInjector", 1, "troopUin: " + peerUid + ", plus icon app info: " + j16);
        m3.reportLevelZeroRedInfo(11, 30);
    }

    @Override // com.tencent.qqnt.aio.api.h
    public void h(View redDot) {
        Intrinsics.checkNotNullParameter(redDot, "redDot");
        RedTouch redTouch = redDot instanceof RedTouch ? (RedTouch) redDot : null;
        if (redTouch != null) {
            redTouch.clearRedTouch();
        }
    }

    @Override // com.tencent.qqnt.aio.api.h
    public View i(Context context, View target) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        RedTouch redTouch = new RedTouch(context, target);
        redTouch.setGravity(8388661);
        redTouch.applyTo();
        return redTouch;
    }

    private final BusinessInfoCheckUpdate.AppInfo k(IRedTouchManager redTouchManager, String redDotId, String uin) {
        return redTouchManager.getAppInfoFilterByID(10, redDotId, uin);
    }
}
