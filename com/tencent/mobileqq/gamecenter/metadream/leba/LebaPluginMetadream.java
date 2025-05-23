package com.tencent.mobileqq.gamecenter.metadream.leba;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.c;
import com.tencent.mobileqq.gamecenter.metadream.leba.LebaPluginMetadream;
import com.tencent.mobileqq.gamecenter.ui.MarqueeTextView;
import com.tencent.mobileqq.gamecenter.ui.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.leba.entity.BaseLebaPluginItem;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.f;
import com.tencent.mobileqq.leba.entity.n;
import com.tencent.mobileqq.minigame.leba.IMiniGameLebaController;
import com.tencent.mobileqq.minigame.va.MiniGameVAMMKVKEY;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u0016\u0010\u0014\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/metadream/leba/LebaPluginMetadream;", "Lcom/tencent/mobileqq/leba/entity/BaseLebaPluginItem;", "Lcom/tencent/mobileqq/gamecenter/api/c;", "", "E", "Lcom/tencent/mobileqq/gamecenter/ui/o;", "c", "d", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/leba/entity/n;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/leba/entity/f;", CacheTable.TABLE_NAME, "H", "a", "", "b", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/gamecenter/ui/o;", "mChildView", "", "()J", "resId", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class LebaPluginMetadream extends BaseLebaPluginItem implements c {

    /* renamed from: C, reason: from kotlin metadata */
    private o mChildView = new o();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(LebaPluginMetadream this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void E() {
        super.E();
        ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).setGameViewContainer(this);
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public void H(View v3, n item, f reportInfo) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(reportInfo, "reportInfo");
        ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).onItemClickBefore(n());
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_MINI_GAME);
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQ\u2026QMMKVFile.FILE_MINI_GAME)");
        fromV2.encodeBool(MiniGameVAMMKVKEY.MINI_GAME_META_LEBA_CLICK + ("_" + MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin()), true);
        super.H(v3, item, reportInfo);
        ((IMiniGameLebaController) QRoute.api(IMiniGameLebaController.class)).onItemClick();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    public View a() {
        return o();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    public String b() {
        LebaPluginInfo lebaPluginInfo;
        n r16 = r();
        if (r16 == null || (lebaPluginInfo = r16.f240505b) == null) {
            return null;
        }
        return lebaPluginInfo.strResURL;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    public o c() {
        o oVar = new o();
        this.mChildView = oVar;
        View o16 = o();
        oVar.f213338a = o16 != null ? (LinearLayout) o16.findViewById(R.id.ypr) : null;
        o oVar2 = this.mChildView;
        if (oVar2 != null) {
            View o17 = o();
            oVar2.f213339b = o17 != null ? (FrameLayout) o17.findViewById(R.id.yps) : null;
        }
        View o18 = o();
        LayoutInflater from = LayoutInflater.from(o18 != null ? o18.getContext() : null);
        o oVar3 = this.mChildView;
        from.inflate(R.layout.gxh, oVar3 != null ? oVar3.f213339b : null);
        o oVar4 = this.mChildView;
        if (oVar4 != null) {
            View o19 = o();
            oVar4.f213340c = o19 != null ? (RelativeLayout) o19.findViewById(R.id.ypw) : null;
        }
        o oVar5 = this.mChildView;
        if (oVar5 != null) {
            View o26 = o();
            oVar5.f213341d = o26 != null ? (ImageView) o26.findViewById(R.id.y7a) : null;
        }
        o oVar6 = this.mChildView;
        if (oVar6 != null) {
            View o27 = o();
            oVar6.f213342e = o27 != null ? (ImageView) o27.findViewById(R.id.y2j) : null;
        }
        o oVar7 = this.mChildView;
        if (oVar7 != null) {
            View o28 = o();
            oVar7.f213343f = o28 != null ? (MarqueeTextView) o28.findViewById(R.id.f110146hq) : null;
        }
        o oVar8 = this.mChildView;
        if (oVar8 != null) {
            View o29 = o();
            oVar8.f213344g = o29 != null ? (LinearLayout) o29.findViewById(R.id.ypj) : null;
        }
        o oVar9 = this.mChildView;
        if (oVar9 != null) {
            View o36 = o();
            oVar9.f213345h = o36 != null ? (ImageView) o36.findViewById(R.id.y2k) : null;
        }
        o oVar10 = this.mChildView;
        if (oVar10 != null) {
            View o37 = o();
            oVar10.f213347j = o37 != null ? (ImageView) o37.findViewById(R.id.y2l) : null;
        }
        o oVar11 = this.mChildView;
        if (oVar11 != null) {
            View o38 = o();
            oVar11.f213346i = o38 != null ? (ImageView) o38.findViewById(R.id.y6a) : null;
        }
        o oVar12 = this.mChildView;
        if (oVar12 != null) {
            View o39 = o();
            oVar12.f213348k = o39 != null ? (TextView) o39.findViewById(R.id.k6s) : null;
        }
        return this.mChildView;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.c
    public void d() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: fd1.a
            @Override // java.lang.Runnable
            public final void run() {
                LebaPluginMetadream.S(LebaPluginMetadream.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.leba.entity.BaseLebaPluginItem
    public long v() {
        return 4048L;
    }
}
