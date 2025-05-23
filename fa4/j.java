package fa4;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.data.dress.task.NormalDressStrategy;
import com.tencent.sqshow.zootopia.nativeui.view.page.ZPlanAvatarPreDownloadManager;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.sqshow.zootopia.view.ZplanExcludeFontPaddingTextView;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.AppSetting;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m94.DressControllerInitData;
import m94.DressErrorMsg;
import n74.v;
import n74.w;
import org.slf4j.Marker;
import uv4.az;
import uv4.ba;
import uv4.bc;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 N2\u00020\u0001:\u0001OB\u001f\u0012\u0006\u00103\u001a\u000201\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010:\u001a\u00020\r\u00a2\u0006\u0004\bL\u0010MJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0018\u001a\n \u0017*\u0004\u0018\u00010\u00160\u0016H\u0002J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J \u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001a\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0004R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u00102R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0014\u0010:\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00109R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00109R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\"\u0010G\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0E0D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010HR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020J0D8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010F\u00a8\u0006P"}, d2 = {"Lfa4/j;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Luv4/az;", "itemData", "", "E", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "B", "D", "T", "U", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "needAnim", BdhLogUtil.LogTag.Tag_Req, BdhLogUtil.LogTag.Tag_Conn, "", "remainSecond", "m0", "remainTimeMills", "k0", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "I", "b0", "storeItem", "dressUpStartTime", "", "", "", "H", "Landroid/view/View;", "it", "O", "J", "e0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "W", "a0", "N", "Luv4/bc;", "price", "f0", "j0", "L", "M", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "onRecycled", "Ln74/v;", "Ln74/v;", "viewBinding", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "G", "Z", "isUgcData", "isDressed", "isSelected", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", "Ljava/lang/Runnable;", "K", "Ljava/lang/Runnable;", "showLoadingTask", "Landroidx/lifecycle/Observer;", "", "Landroidx/lifecycle/Observer;", "mDressListObserver", "Luv4/az;", "mData", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "mItemUpdateObserver", "<init>", "(Ln74/v;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Z)V", "P", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class j extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final v viewBinding;

    /* renamed from: F, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: G, reason: from kotlin metadata */
    private final boolean isUgcData;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isDressed;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isSelected;

    /* renamed from: J, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: K, reason: from kotlin metadata */
    private final Runnable showLoadingTask;

    /* renamed from: L, reason: from kotlin metadata */
    private Observer<List<String>> mDressListObserver;

    /* renamed from: M, reason: from kotlin metadata */
    private az mData;

    /* renamed from: N, reason: from kotlin metadata */
    private final Observer<com.tencent.sqshow.zootopia.nativeui.data.l> mItemUpdateObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"fa4/j$d", "Lm94/h;", "Lcom/tencent/sqshow/zootopia/nativeui/data/dress/task/b;", "task", "Lm94/e;", "errorMsg", "", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class d implements m94.h {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.sqshow.zootopia.nativeui.data.j f398115b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ az f398116c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f398117d;

        d(com.tencent.sqshow.zootopia.nativeui.data.j jVar, az azVar, long j3) {
            this.f398115b = jVar;
            this.f398116c = azVar;
            this.f398117d = j3;
        }

        @Override // m94.h
        public void a(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task, DressErrorMsg errorMsg) {
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            QLog.i("GoodsDetailItemViewHolder", 1, "onError");
            j.this.J();
            j.this.R(this.f398115b, this.f398116c, true);
        }

        @Override // m94.h
        public void b(com.tencent.sqshow.zootopia.nativeui.data.dress.task.b task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("GoodsDetailItemViewHolder", 1, "onSuccess");
            j.this.J();
            if (j.this.isDressed) {
                VideoReport.reportEvent("ev_zplan_try_clothes_success", null, j.this.H(this.f398116c, this.f398117d));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"fa4/j$e", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class e extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j f398118a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j3, j jVar) {
            super(j3, 1000L);
            this.f398118a = jVar;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f398118a.viewBinding.f419456r.setText("\u5df2\u8fc7\u671f");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            this.f398118a.m0(millisUntilFinished / 1000);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(v viewBinding, com.tencent.sqshow.zootopia.nativeui.data.j channel, boolean z16) {
        super(viewBinding.getRoot());
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.viewBinding = viewBinding;
        this.channel = channel;
        this.isUgcData = z16;
        this.showLoadingTask = new Runnable() { // from class: fa4.b
            @Override // java.lang.Runnable
            public final void run() {
                j.i0(j.this);
            }
        };
        this.mDressListObserver = new Observer() { // from class: fa4.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                j.P(j.this, (List) obj);
            }
        };
        this.mItemUpdateObserver = new Observer() { // from class: fa4.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                j.Q(j.this, (com.tencent.sqshow.zootopia.nativeui.data.l) obj);
            }
        };
    }

    private final void A(az itemData) {
        if (r94.b.B(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n(), Integer.valueOf(itemData.f440296w))) {
            this.viewBinding.f419451m.setVisibility(0);
            v vVar = this.viewBinding;
            vVar.f419451m.setText(vVar.getRoot().getContext().getResources().getString(R.string.xrm));
            return;
        }
        this.viewBinding.f419451m.setVisibility(8);
    }

    private final void B(com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        LifecycleOwner lifecycleOwner = channel.getLifecycleOwner();
        if (lifecycleOwner != null) {
            channel.l().observe(lifecycleOwner, this.mDressListObserver);
            channel.getStoreItemPool().c().observe(lifecycleOwner, this.mItemUpdateObserver);
        }
    }

    private final void C(az itemData) {
        int i3 = itemData.A;
        if (i3 > 0) {
            QLog.i("GoodsDetailItemViewHolder", 1, "itemData.expireTime = " + i3);
            L();
            M();
            this.viewBinding.f419456r.setVisibility(0);
            long serverTimeMillis = itemData.A - (NetConnInfoCenter.getServerTimeMillis() / 1000);
            if (serverTimeMillis > 0) {
                m0(serverTimeMillis);
                if (serverTimeMillis < 86400) {
                    k0(serverTimeMillis * 1000);
                    return;
                }
                return;
            }
            this.viewBinding.f419456r.setText("\u5df2\u8fc7\u671f");
            return;
        }
        if (!TextUtils.isEmpty(itemData.f440286m)) {
            QLog.i("GoodsDetailItemViewHolder", 1, "itemData.showInfo = " + itemData.f440286m);
            M();
            L();
            this.viewBinding.f419456r.setVisibility(0);
            this.viewBinding.f419456r.setText(itemData.f440286m);
            return;
        }
        if (itemData.f440295v > 0) {
            QLog.i("GoodsDetailItemViewHolder", 1, "item.havingCount > 0 position=" + getAdapterPosition());
            M();
            L();
            this.viewBinding.f419456r.setVisibility(0);
            this.viewBinding.f419456r.setText("\u5df2\u62e5\u6709");
            return;
        }
        bc bcVar = itemData.f440287n;
        if (bcVar == null) {
            QLog.i("GoodsDetailItemViewHolder", 1, "price is null");
            L();
            M();
            this.viewBinding.f419456r.setVisibility(8);
            return;
        }
        N();
        int i16 = bcVar.f440312a;
        if (i16 == 1) {
            j0();
            this.viewBinding.f419455q.setText(String.valueOf(bcVar.f440315d));
            this.viewBinding.f419447i.setImageResource(R.drawable.ilx);
        } else if (i16 == 2 || i16 == 3) {
            j0();
            this.viewBinding.f419455q.setText(String.valueOf(bcVar.f440316e));
            this.viewBinding.f419447i.setImageResource(R.drawable.f159901im2);
        } else {
            if (i16 != 4) {
                QLog.i("GoodsDetailItemViewHolder", 1, "priceType is error priceType:" + i16);
                return;
            }
            f0(bcVar);
            this.viewBinding.f419452n.setText(Marker.ANY_NON_NULL_MARKER);
        }
    }

    private final void D(az itemData, com.tencent.sqshow.zootopia.nativeui.data.j channel) {
        this.viewBinding.f419450l.b(itemData, true, channel);
    }

    private final void E(az itemData) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_item_id", r94.b.K(itemData));
        String jsonElement = r94.b.J(itemData).toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "itemData.reportExtInfoJson().toString()");
        hashMap.put("zplan_ext_info", jsonElement);
        if (this.isUgcData) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put(SquareReportConst.Key.KEY_ZPLAN_INTIMATE_ANIMATION_TYPE, str);
        ZplanViewReportHelper mReporter = this.channel.getReporter().getMReporter();
        RelativeLayout root = this.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        mReporter.g(root, "em_zplan_item_detail_ugcitem", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        VideoReport.traversePage(this.viewBinding.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> H(az storeItem, long dressUpStartTime) {
        String h16;
        DressControllerInitData mInitData;
        ZootopiaSource source;
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        b94.d avatarDressController = this.channel.getAvatarDressController();
        if (avatarDressController == null || (mInitData = avatarDressController.getMInitData()) == null || (source = mInitData.getSource()) == null || (h16 = ah.b(source)) == null) {
            h16 = ZPlanAvatarPreDownloadManager.f371947a.h();
        }
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, h16);
        hashMap.put("zplan_item_id", r94.b.K(storeItem));
        hashMap.put("zplan_gender", Integer.valueOf(com.tencent.sqshow.zootopia.nativeui.data.c.f370920a.n().getIndex()));
        hashMap.put("zplan_is_ai_sculpt", "0");
        hashMap.put("zplan_is_pre_download", Integer.valueOf(ZPlanAvatarPreDownloadManager.f371947a.k(r94.b.M(storeItem), storeItem.f440275b) ? 1 : 0));
        hashMap.put("zplan_use_times", String.valueOf(System.currentTimeMillis() - dressUpStartTime));
        hashMap.put("zplan_try_clothes_source", "avatar_mall_assemble_goods");
        return hashMap;
    }

    private final Resources I() {
        return this.viewBinding.getRoot().getContext().getResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.showLoadingTask);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: fa4.i
            @Override // java.lang.Runnable
            public final void run() {
                j.K(j.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewBinding.f419448j.setVisibility(8);
        this$0.viewBinding.f419448j.g();
    }

    private final void L() {
        this.viewBinding.f419452n.setVisibility(8);
        this.viewBinding.f419453o.setVisibility(8);
        this.viewBinding.f419454p.setVisibility(8);
        this.viewBinding.f419456r.setVisibility(8);
        this.viewBinding.f419445g.setVisibility(8);
        this.viewBinding.f419446h.setVisibility(8);
    }

    private final void M() {
        this.viewBinding.f419455q.setVisibility(8);
        this.viewBinding.f419447i.setVisibility(8);
    }

    private final void N() {
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.viewBinding.f419453o;
        t74.m mVar = t74.m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        zplanExcludeFontPaddingTextView.setTypeface(mVar.a(assets));
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView2 = this.viewBinding.f419454p;
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        zplanExcludeFontPaddingTextView2.setTypeface(mVar.a(assets2));
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView3 = this.viewBinding.f419455q;
        AssetManager assets3 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets3, "context.assets");
        zplanExcludeFontPaddingTextView3.setTypeface(mVar.a(assets3));
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView4 = this.viewBinding.f419455q;
        AssetManager assets4 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets4, "context.assets");
        zplanExcludeFontPaddingTextView4.setTypeface(mVar.a(assets4));
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView5 = this.viewBinding.f419452n;
        AssetManager assets5 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets5, "context.assets");
        zplanExcludeFontPaddingTextView5.setTypeface(mVar.a(assets5));
    }

    private final void O(az itemData, com.tencent.sqshow.zootopia.nativeui.data.j channel, View it) {
        HashMap hashMap = new HashMap();
        hashMap.put("zplan_item_id", r94.b.K(itemData));
        String jsonElement = r94.b.J(itemData).toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "itemData.reportExtInfoJson().toString()");
        hashMap.put("zplan_ext_info", jsonElement);
        channel.getReporter().getMReporter().e(it, "em_zplan_item_detail_ugcitem", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(j this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("GoodsDetailItemViewHolder", 1, "observer change");
        az azVar = this$0.mData;
        if (azVar != null) {
            this$0.R(this$0.channel, azVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(j this$0, com.tencent.sqshow.zootopia.nativeui.data.l lVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        az azVar = this$0.mData;
        if (azVar == null) {
            return;
        }
        az b16 = lVar.b(azVar);
        if (Intrinsics.areEqual(b16, azVar)) {
            return;
        }
        QLog.i("GoodsDetailItemViewHolder", 1, "mItemUpdateObserver data updated!");
        this$0.z(b16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(com.tencent.sqshow.zootopia.nativeui.data.j channel, az itemData, boolean needAnim) {
        this.isDressed = r94.b.x(itemData, channel.l().getValue());
        QLog.i("GoodsDetailItemViewHolder", 1, "refreshSelectState index = " + getAdapterPosition() + ", isDressed = " + this.isDressed + " isSelected = " + this.isSelected);
        if (this.isDressed) {
            W(itemData, needAnim);
        } else {
            a0(itemData, needAnim);
        }
    }

    private final void T() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.isSelected = false;
        this.isDressed = false;
        this.channel.l().removeObserver(this.mDressListObserver);
        this.channel.getStoreItemPool().c().removeObserver(this.mItemUpdateObserver);
    }

    private final void U() {
        w binding = this.viewBinding.f419450l.getBinding();
        RoundCornerImageView roundCornerImageView = binding != null ? binding.f419459c : null;
        if (roundCornerImageView != null) {
            roundCornerImageView.setScaleX(1.0f);
        }
        w binding2 = this.viewBinding.f419450l.getBinding();
        RoundCornerImageView roundCornerImageView2 = binding2 != null ? binding2.f419459c : null;
        if (roundCornerImageView2 != null) {
            roundCornerImageView2.setScaleY(1.0f);
        }
        w binding3 = this.viewBinding.f419450l.getBinding();
        RoundCornerImageView roundCornerImageView3 = binding3 != null ? binding3.f419459c : null;
        if (roundCornerImageView3 != null) {
            roundCornerImageView3.setTranslationY(0.0f);
        }
        w binding4 = this.viewBinding.f419450l.getBinding();
        FrameLayout frameLayout = binding4 != null ? binding4.f419458b : null;
        if (frameLayout != null) {
            frameLayout.setTranslationY(0.0f);
        }
        this.viewBinding.f419441c.setVisibility(8);
        this.viewBinding.f419440b.setVisibility(8);
        this.viewBinding.getRoot().setBackgroundResource(R.drawable.h4n);
        this.viewBinding.getRoot().setElevation(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(ba baVar, j this$0, az item, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (!AppSetting.isPublicVersion() && TextUtils.isEmpty(baVar.f440302c)) {
            QQToast.makeText(this$0.viewBinding.getRoot().getContext(), "\u8df3\u8f6c\u94fe\u63a5\u4e3a\u7a7a", 0).show();
        } else {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.viewBinding.getRoot().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "viewBinding.root.context");
            String str = baVar.f440302c;
            Intrinsics.checkNotNullExpressionValue(str, "activity.activityUrl");
            iSchemeApi.launchScheme(context, str);
        }
        HashMap hashMap = new HashMap();
        String K = r94.b.K(item);
        if (K == null) {
            K = "";
        }
        hashMap.put("zplan_item_id", K);
        ba baVar2 = item.f440288o;
        String str2 = baVar2 != null ? baVar2.f440301b : null;
        hashMap.put("zplan_act_id", str2 != null ? str2 : "");
        String jsonElement = r94.b.J(item).toString();
        Intrinsics.checkNotNullExpressionValue(jsonElement, "item.reportExtInfoJson().toString()");
        hashMap.put("zplan_ext_info", jsonElement);
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mReporter.e(it, "em_zplan_activity_entrance", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(j this$0, HashMap reportParams) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(reportParams, "$reportParams");
        ZplanViewReportHelper mReporter = this$0.channel.getReporter().getMReporter();
        TextView textView = this$0.viewBinding.f419441c;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.bottomTextActivity");
        mReporter.g(textView, "em_zplan_activity_entrance", (r16 & 4) != 0 ? null : reportParams, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a0(az item, boolean needAnim) {
        QLog.i("GoodsDetailItemViewHolder", 1, "runUnSelectedAnimIfNeed needAnim = " + needAnim + " isSelected=" + this.isSelected + " ");
        if (this.isSelected) {
            AnimatorSet animatorSet = new AnimatorSet();
            w binding = this.viewBinding.f419450l.getBinding();
            animatorSet.play(ObjectAnimator.ofFloat(binding != null ? binding.f419459c : null, "translationY", com.tencent.sqshow.zootopia.utils.i.d(-3.0f), 0.0f));
            if (item.f440295v <= 0) {
                ba baVar = item.f440288o;
                if (baVar != null && com.tencent.mobileqq.zootopia.utils.g.f(baVar)) {
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.viewBinding.f419441c, BasicAnimation.KeyPath.SCALE_Y, 1.0f, 0.0f);
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.viewBinding.f419440b, "translationY", 0.0f, r1.getHeight());
                    w binding2 = this.viewBinding.f419450l.getBinding();
                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(binding2 != null ? binding2.f419458b : null, "translationY", com.tencent.sqshow.zootopia.utils.i.e(-14), 0.0f);
                    animatorSet.play(ofFloat);
                    animatorSet.play(ofFloat2);
                    animatorSet.play(ofFloat3);
                    animatorSet.setDuration(needAnim ? 200L : 0L);
                    animatorSet.addListener(new c());
                    animatorSet.start();
                    this.isSelected = false;
                }
            }
            this.viewBinding.f419441c.setVisibility(8);
            this.viewBinding.f419440b.setVisibility(8);
            animatorSet.setDuration(needAnim ? 200L : 0L);
            animatorSet.addListener(new c());
            animatorSet.start();
            this.isSelected = false;
        }
    }

    private final void b0(final com.tencent.sqshow.zootopia.nativeui.data.j channel, final az itemData) {
        this.viewBinding.getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: fa4.e
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean c06;
                c06 = j.c0(j.this, channel, itemData, view);
                return c06;
            }
        });
        this.viewBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: fa4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.d0(j.this, itemData, channel, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c0(j this$0, com.tencent.sqshow.zootopia.nativeui.data.j channel, az itemData, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        com.tencent.sqshow.zootopia.nativeui.menu.a a16 = com.tencent.sqshow.zootopia.nativeui.menu.a.INSTANCE.a();
        RelativeLayout root = this$0.viewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "viewBinding.root");
        com.tencent.sqshow.zootopia.nativeui.menu.a.k(a16, root, channel, itemData, null, 8, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0(j this$0, az itemData, com.tencent.sqshow.zootopia.nativeui.data.j channel, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(channel, "$channel");
        this$0.e0();
        if (!this$0.isDressed) {
            this$0.W(itemData, true);
        } else {
            this$0.a0(itemData, true);
        }
        itemData.K = "avatar_mall_assemble_goods";
        long currentTimeMillis = System.currentTimeMillis();
        b94.d avatarDressController = channel.getAvatarDressController();
        if (avatarDressController != null) {
            avatarDressController.Lf(itemData, new d(channel, itemData, currentTimeMillis), NormalDressStrategy.ON_OR_OFF);
        }
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.O(itemData, channel, it);
    }

    private final void e0() {
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.showLoadingTask, 500L);
    }

    private final void f0(bc price) {
        this.viewBinding.f419452n.setVisibility(0);
        this.viewBinding.f419453o.setVisibility(0);
        this.viewBinding.f419454p.setVisibility(0);
        this.viewBinding.f419456r.setVisibility(8);
        this.viewBinding.f419455q.setVisibility(8);
        this.viewBinding.f419445g.setVisibility(0);
        this.viewBinding.f419446h.setVisibility(0);
        this.viewBinding.f419447i.setVisibility(8);
        this.viewBinding.f419454p.setText(String.valueOf(price.f440316e));
        this.viewBinding.f419446h.setImageResource(R.drawable.f159901im2);
        this.viewBinding.f419453o.setText(String.valueOf(price.f440315d));
        this.viewBinding.f419445g.setImageResource(R.drawable.ilx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(j this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.viewBinding.f419448j.setVisibility(0);
        this$0.viewBinding.f419448j.f();
    }

    private final void j0() {
        L();
        this.viewBinding.f419447i.setVisibility(0);
        this.viewBinding.f419455q.setVisibility(0);
    }

    private final void k0(long remainTimeMills) {
        if (this.countDownTimer == null) {
            this.countDownTimer = new e(remainTimeMills, this);
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(long remainSecond) {
        String a16 = t.f373300a.a(remainSecond);
        String string = this.viewBinding.getRoot().getContext().getString(R.string.xlj, a16);
        Intrinsics.checkNotNullExpressionValue(string, "viewBinding.root.context\u2026ountdownTimeTxt\n        )");
        ZplanExcludeFontPaddingTextView zplanExcludeFontPaddingTextView = this.viewBinding.f419456r;
        Intrinsics.checkNotNullExpressionValue(zplanExcludeFontPaddingTextView, "viewBinding.tvSpecialHint");
        m84.b.i(zplanExcludeFontPaddingTextView, string, I().getColor(R.color.f8346p), 0, a16.length());
    }

    public final void onRecycled() {
        T();
        U();
    }

    public final void z(az itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        QLog.i("GoodsDetailItemViewHolder", 1, "bindData itemData:" + itemData);
        this.mData = itemData;
        b0(this.channel, itemData);
        D(itemData, this.channel);
        A(itemData);
        C(itemData);
        R(this.channel, itemData, false);
        B(this.channel);
        E(itemData);
    }

    private final void W(final az item, boolean needAnim) {
        String str;
        QLog.i("GoodsDetailItemViewHolder", 1, "runSelectedAnimIfNeed needAnim = " + needAnim + " isSelected=" + this.isSelected + " ");
        if (this.isSelected) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        w binding = this.viewBinding.f419450l.getBinding();
        animatorSet.play(ObjectAnimator.ofFloat(binding != null ? binding.f419459c : null, "translationY", 0.0f, com.tencent.sqshow.zootopia.utils.i.d(-3.0f)));
        if (item.f440295v <= 0) {
            ba baVar = item.f440288o;
            if (baVar != null && com.tencent.mobileqq.zootopia.utils.g.f(baVar)) {
                final ba baVar2 = item.f440288o;
                QLog.i("GoodsDetailItemViewHolder", 1, "it.btnInfo = " + baVar2.f440303d);
                this.viewBinding.f419441c.setVisibility(0);
                this.viewBinding.f419440b.setVisibility(0);
                TextView textView = this.viewBinding.f419441c;
                if (TextUtils.isEmpty(baVar2.f440303d)) {
                    str = "\u8df3\u8f6c\u6d3b\u52a8";
                } else {
                    str = baVar2.f440303d;
                }
                textView.setText(str);
                this.viewBinding.f419441c.setOnClickListener(new View.OnClickListener() { // from class: fa4.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        j.Y(ba.this, this, item, view);
                    }
                });
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.viewBinding.f419441c, BasicAnimation.KeyPath.SCALE_Y, 0.5f, 1.0f);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.viewBinding.f419440b, "translationY", this.viewBinding.f419440b.getHeight(), 0.0f);
                w binding2 = this.viewBinding.f419450l.getBinding();
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(binding2 != null ? binding2.f419458b : null, "translationY", 0.0f, com.tencent.sqshow.zootopia.utils.i.e(-14));
                animatorSet.play(ofFloat2);
                animatorSet.play(ofFloat);
                animatorSet.play(ofFloat3);
                final HashMap hashMap = new HashMap();
                String K = r94.b.K(item);
                if (K == null) {
                    K = "";
                }
                hashMap.put("zplan_item_id", K);
                ba baVar3 = item.f440288o;
                String str2 = baVar3 != null ? baVar3.f440301b : null;
                hashMap.put("zplan_act_id", str2 != null ? str2 : "");
                String jsonElement = r94.b.J(item).toString();
                Intrinsics.checkNotNullExpressionValue(jsonElement, "item.reportExtInfoJson().toString()");
                hashMap.put("zplan_ext_info", jsonElement);
                this.itemView.post(new Runnable() { // from class: fa4.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        j.Z(j.this, hashMap);
                    }
                });
            }
        }
        animatorSet.setDuration(needAnim ? 200L : 0L);
        animatorSet.addListener(new b());
        animatorSet.start();
        this.isSelected = true;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"fa4/j$b", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements Animator.AnimatorListener {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            j.this.viewBinding.getRoot().setElevation(com.tencent.sqshow.zootopia.utils.i.b(3));
            j.this.viewBinding.getRoot().setBackgroundResource(R.drawable.h4o);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"fa4/j$c", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            j.this.viewBinding.f419441c.setVisibility(8);
            j.this.viewBinding.f419440b.setVisibility(8);
            j.this.viewBinding.getRoot().setBackgroundResource(R.drawable.h4n);
            j.this.viewBinding.getRoot().setElevation(0.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
