package com.tencent.sqshow.zootopia.usercenter.view.items;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zplan.api.IZplanCacheApi;
import com.tencent.mobileqq.zplan.api.ZplanCacheComponentType;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.usercenter.friend.data.FollowStateChangedEvent;
import com.tencent.sqshow.zootopia.usercenter.view.items.UserCenterInfoCard;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.aj;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.sqshow.zootopia.utils.ui.RoundCornerImageView;
import com.tencent.state.report.SquareReportConst;
import hu4.f;
import hu4.g;
import java.util.HashMap;
import java.util.Map;
import jc4.UserCenterCardData;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import n74.dm;
import nc4.a;
import org.slf4j.Marker;
import t74.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0017\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\u0016\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0011H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0003H\u0002J \u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\u0011H\u0002J\u0018\u0010+\u001a\u00020\u00032\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0011H\u0016J\b\u0010,\u001a\u00020\u0003H\u0014R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010@\u001a\u00020=8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006G"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/view/items/UserCenterInfoCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lnc4/a;", "", "k1", "e1", "", "eventId", "actionType", "m1", "U0", "Z0", "", "", "M0", "V0", "o1", "", "relationType", "g1", "resId", "l1", "currentRelationType", "N0", "newReleationType", "Y0", "Lsu4/h;", "result", "R0", "p1", "T0", "Q0", "O0", "P0", "i1", "Landroid/widget/TextView;", "numTxv", "unitTxv", "number", ICustomDataEditor.STRING_PARAM_1, "Ljc4/a;", "data", "position", "w0", NodeProps.ON_ATTACHED_TO_WINDOW, "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "d", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "Lhu4/f;", "e", "Lhu4/f;", "mData", "Ln74/dm;", "f", "Ln74/dm;", "mBinding", "", h.F, "Z", "mFollowingTaskRunning", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "i", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserCenterInfoCard extends ConstraintLayout implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private f mData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private dm mBinding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mFollowingTaskRunning;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/usercenter/view/items/UserCenterInfoCard$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lsu4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements e<su4.h> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f373193e;

        b(int i3) {
            this.f373193e = i3;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(su4.h result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("UserInfoCard_", 1, "onResultSuccess new relation: " + result.f434790a.f434783b);
            UserCenterInfoCard.this.g1(result.f434790a.f434783b);
            UserCenterInfoCard.this.Y0(result.f434790a.f434783b);
            UserCenterInfoCard.this.R0(result);
            UserCenterInfoCard.this.mFollowingTaskRunning = false;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("UserInfoCard_", 1, "onResultFailure error:" + message + ", message:" + message);
            UserCenterInfoCard.this.g1(this.f373193e);
            Context context = UserCenterInfoCard.this.getContext();
            if (message == null) {
                message = "\u64cd\u4f5c\u5931\u8d25";
            }
            QQToast.makeText(context, 1, message, 0).show();
            UserCenterInfoCard.this.mFollowingTaskRunning = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCenterInfoCard(Context context, com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.userCenterPage = userCenterPage;
        this.mData = new f();
        dm f16 = dm.f(LayoutInflater.from(context), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.mBinding = f16;
        this.mReporter = new ZplanViewReportHelper();
        setBackgroundColor(0);
        int statusBarHeight = userCenterPage.getStatusBarHeight();
        ViewGroup.LayoutParams layoutParams = this.mBinding.W.getLayoutParams();
        layoutParams = layoutParams == null ? new LinearLayout.LayoutParams(-1, statusBarHeight) : layoutParams;
        layoutParams.height = statusBarHeight;
        this.mBinding.W.setLayoutParams(layoutParams);
        ((IZplanCacheApi) QRoute.api(IZplanCacheApi.class)).saveCache(context, ZplanCacheComponentType.USER_CENTER_USER_INFO_CARD, this);
        this.mBinding.f419308f.setImageResource(R.drawable.imn);
        RoundCornerImageView bgIgv = this.mBinding.f419308f;
        float e16 = i.e(16);
        float e17 = i.e(16);
        Intrinsics.checkNotNullExpressionValue(bgIgv, "bgIgv");
        RoundCornerImageView.setRadius$default(bgIgv, 0.0f, 0.0f, e17, e16, 3, null);
    }

    private final Map<String, Object> M0() {
        HashMap hashMapOf;
        if (this.mBinding.f419326x.getVisibility() != 0) {
            return null;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("zplan_redpoint_type", 2));
        return hashMapOf;
    }

    private final void N0(int currentRelationType) {
        QLog.i("UserInfoCard_", 1, "clickFollowArea mFollowingTaskRunning :" + this.mFollowingTaskRunning + ", currentRelationType:" + currentRelationType);
        if (this.mFollowingTaskRunning) {
            return;
        }
        this.mFollowingTaskRunning = true;
        this.mBinding.F.setText("");
        this.mBinding.F.setCompoundDrawables(null, null, null, null);
        this.mBinding.G.setVisibility(0);
        Object background = this.mBinding.G.getBackground();
        Animatable animatable = background instanceof Animatable ? (Animatable) background : null;
        if (animatable != null) {
            animatable.start();
        }
        b bVar = new b(currentRelationType);
        QLog.i("UserInfoCard_", 1, "clickFollowArea RelationUpdateReq, uid:" + this.userCenterPage.getCurrentUin());
        lc4.a.f414373a.i(this.userCenterPage.getCurrentUin(), currentRelationType, bVar);
    }

    private final String O0() {
        String str = this.mData.f406353d;
        Intrinsics.checkNotNullExpressionValue(str, "mData.birthday");
        return str;
    }

    private final String P0() {
        String str = this.mData.f406354e;
        Intrinsics.checkNotNullExpressionValue(str, "mData.constellation");
        return str;
    }

    private final String Q0() {
        String str = this.mData.f406355f;
        if (str == null || str.length() == 0) {
            return "";
        }
        f fVar = this.mData;
        String str2 = fVar.f406356g + fVar.f406357h;
        if (str2.length() == 0) {
            String str3 = this.mData.f406355f;
            Intrinsics.checkNotNullExpressionValue(str3, "{\n            mData.country\n        }");
            return str3;
        }
        return this.mData.f406355f + " \u00b7 " + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R0(su4.h result) {
        su4.i iVar = new su4.i();
        f fVar = this.mData;
        iVar.f434795d = fVar.f406363n;
        su4.e eVar = result.f434790a;
        iVar.f434792a = eVar.f434782a;
        iVar.f434793b = fVar.f406351b;
        iVar.f434794c = fVar.f406362m;
        iVar.f434797f = fVar.f406368s;
        iVar.f434796e = eVar.f434783b;
        SimpleEventBus.getInstance().dispatchEvent(new FollowStateChangedEvent(iVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0() {
        VideoReport.traverseExposure();
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void T0() {
        boolean z16;
        int i3;
        String Q0 = Q0();
        String O0 = O0();
        String P0 = P0();
        if (O0.length() == 0) {
            O0 = P0;
        } else {
            if (!(P0.length() == 0)) {
                O0 = O0 + " \u00b7 " + P0;
            }
        }
        int i16 = this.mData.f406352c;
        if (i16 == 1) {
            this.mBinding.N.setText("\u7537");
            this.mBinding.M.setImageResource(R.drawable.ij_);
        } else if (i16 == 2) {
            this.mBinding.N.setText("\u5973");
            this.mBinding.M.setImageResource(R.drawable.ij6);
        }
        this.mBinding.T.setText(Q0);
        this.mBinding.f419309g.setText(O0);
        if (Q0.length() == 0) {
            this.mBinding.T.setVisibility(8);
            this.mBinding.S.setVisibility(8);
        } else {
            this.mBinding.T.setVisibility(0);
            if (O0.length() == 0) {
                this.mBinding.S.setVisibility(8);
            } else {
                this.mBinding.S.setVisibility(0);
            }
        }
        if (O0.length() == 0) {
            this.mBinding.f419309g.setVisibility(8);
        } else {
            this.mBinding.f419309g.setVisibility(0);
        }
        if (!(Q0.length() > 0)) {
            if (!(O0.length() > 0)) {
                z16 = false;
                i3 = this.mData.f406352c;
                if (i3 != 1) {
                    this.mBinding.K.setVisibility(0);
                    if (z16) {
                        this.mBinding.L.setVisibility(0);
                        return;
                    } else {
                        this.mBinding.L.setVisibility(8);
                        return;
                    }
                }
                if (i3 != 2) {
                    this.mBinding.K.setVisibility(8);
                    this.mBinding.L.setVisibility(8);
                    return;
                }
                this.mBinding.K.setVisibility(0);
                if (z16) {
                    this.mBinding.L.setVisibility(0);
                    return;
                } else {
                    this.mBinding.L.setVisibility(8);
                    return;
                }
            }
        }
        z16 = true;
        i3 = this.mData.f406352c;
        if (i3 != 1) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void U0() {
        boolean z16;
        hu4.e eVar;
        hu4.e eVar2;
        String str;
        String str2;
        hu4.e eVar3;
        String str3 = null;
        boolean z17 = true;
        if (this.mData.f406368s && this.userCenterPage.getMStatus() == 2) {
            this.mBinding.U.setVisibility(0);
            hu4.e[] eVarArr = this.mData.f406373z;
            if (eVarArr != null) {
                int length = eVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        eVar3 = null;
                        break;
                    }
                    eVar3 = eVarArr[i3];
                    if (eVar3.f406348a == 1) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (eVar3 != null) {
                    str = eVar3.f406349b;
                    str2 = str != null ? "" : str;
                    if (!(str2.length() != 0)) {
                        this.mBinding.U.setImageResource(R.drawable.ija);
                    } else {
                        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ija);
                        URLImageView uRLImageView = this.mBinding.U;
                        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.qqFriendHintIgv");
                        CommonExKt.w(uRLImageView, str2, drawable, null, 4, null);
                    }
                    z16 = true;
                }
            }
            str = null;
            if (str != null) {
            }
            if (!(str2.length() != 0)) {
            }
            z16 = true;
        } else {
            this.mBinding.U.setVisibility(8);
            z16 = false;
        }
        int i16 = this.mData.f406365p;
        if (i16 == 1) {
            this.mBinding.f419313k.setVisibility(0);
            hu4.e[] eVarArr2 = this.mData.f406373z;
            if (eVarArr2 != null) {
                int length2 = eVarArr2.length;
                int i17 = 0;
                while (true) {
                    if (i17 >= length2) {
                        eVar = null;
                        break;
                    }
                    eVar = eVarArr2[i17];
                    if (eVar.f406348a == 3) {
                        break;
                    } else {
                        i17++;
                    }
                }
                if (eVar != null) {
                    str3 = eVar.f406349b;
                }
            }
            String str4 = str3 == null ? "" : str3;
            if (str4.length() == 0) {
                this.mBinding.f419313k.setImageResource(R.drawable.ij5);
            } else {
                Drawable drawable2 = ContextCompat.getDrawable(getContext(), R.drawable.ij5);
                URLImageView uRLImageView2 = this.mBinding.f419313k;
                Intrinsics.checkNotNullExpressionValue(uRLImageView2, "mBinding.creatorHintIgv");
                CommonExKt.w(uRLImageView2, str4, drawable2, null, 4, null);
            }
        } else if (i16 != 2) {
            this.mBinding.f419313k.setVisibility(8);
            z17 = false;
        } else {
            this.mBinding.f419313k.setVisibility(0);
            hu4.e[] eVarArr3 = this.mData.f406373z;
            if (eVarArr3 != null) {
                int length3 = eVarArr3.length;
                int i18 = 0;
                while (true) {
                    if (i18 >= length3) {
                        eVar2 = null;
                        break;
                    }
                    eVar2 = eVarArr3[i18];
                    if (eVar2.f406348a == 4) {
                        break;
                    } else {
                        i18++;
                    }
                }
                if (eVar2 != null) {
                    str3 = eVar2.f406349b;
                }
            }
            String str5 = str3 == null ? "" : str3;
            if (str5.length() == 0) {
                this.mBinding.f419313k.setImageResource(R.drawable.f159934ij3);
            } else {
                Drawable drawable3 = ContextCompat.getDrawable(getContext(), R.drawable.f159934ij3);
                URLImageView uRLImageView3 = this.mBinding.f419313k;
                Intrinsics.checkNotNullExpressionValue(uRLImageView3, "mBinding.creatorHintIgv");
                CommonExKt.w(uRLImageView3, str5, drawable3, null, 4, null);
            }
        }
        if (z17 && z16) {
            this.mBinding.O.setVisibility(0);
        } else {
            this.mBinding.O.setVisibility(8);
        }
    }

    private final void V0() {
        String str;
        int mStatus = this.userCenterPage.getMStatus();
        if (mStatus == 1) {
            p1();
        } else if (mStatus == 2) {
            o1();
        }
        final HashMap hashMap = new HashMap();
        if (!this.mData.f406369t) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("zplan_user_status", str);
        RelativeLayout relativeLayout = this.mBinding.f419311i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.creatorArea");
        aa.f(relativeLayout, new View.OnClickListener() { // from class: nc4.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.W0(UserCenterInfoCard.this, hashMap, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        RelativeLayout relativeLayout2 = this.mBinding.f419311i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "mBinding.creatorArea");
        zplanViewReportHelper.g(relativeLayout2, "em_zplan_creator_center_btn", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        RelativeLayout relativeLayout3 = this.mBinding.f419322t;
        Intrinsics.checkNotNullExpressionValue(relativeLayout3, "mBinding.entrepotArea");
        aa.d(relativeLayout3, new View.OnClickListener() { // from class: nc4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.X0(UserCenterInfoCard.this, view);
            }
        });
        ZplanViewReportHelper zplanViewReportHelper2 = this.mReporter;
        RelativeLayout relativeLayout4 = this.mBinding.f419322t;
        Intrinsics.checkNotNullExpressionValue(relativeLayout4, "mBinding.entrepotArea");
        zplanViewReportHelper2.g(relativeLayout4, "em_zplan_props_warehouse", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(UserCenterInfoCard this$0, HashMap creatorReportParams, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(creatorReportParams, "$creatorReportParams");
        f fVar = this$0.mData;
        hu4.i iVar = fVar.f406371v;
        if (iVar == null || (str = iVar.f406379b) == null) {
            return;
        }
        if (!fVar.f406369t) {
            Bundle bundle = new Bundle();
            bundle.putString("confirmText", "");
            bundle.putString("confirmTextColor", "");
            bundle.putString("confirmIcon", "");
            str = ((ISchemeApi) QRoute.api(ISchemeApi.class)).appendPageDataToScheme(str, bundle);
        }
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, str);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        RelativeLayout relativeLayout = this$0.mBinding.f419311i;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.creatorArea");
        zplanViewReportHelper.e(relativeLayout, "em_zplan_creator_center_btn", creatorReportParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(UserCenterInfoCard this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        hu4.i iVar = this$0.mData.f406371v;
        String str = iVar != null ? iVar.f406381d : null;
        if (str == null) {
            str = "";
        }
        iSchemeApi.launchScheme(context, str);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        RelativeLayout relativeLayout = this$0.mBinding.f419322t;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.entrepotArea");
        ZplanViewReportHelper.f(zplanViewReportHelper, relativeLayout, "em_zplan_props_warehouse", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(int newReleationType) {
        int i3 = this.mData.f406366q;
        int i16 = ((newReleationType == 1 || newReleationType == 3) ? 1 : 0) - ((i3 == 3 || i3 == 1) ? 1 : 0);
        TextView textView = this.mBinding.f419328z;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.fansNumTxv");
        TextView textView2 = this.mBinding.A;
        Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.fansNumUnitTxv");
        s1(textView, textView2, this.mData.f406360k + i16);
    }

    private final void Z0() {
        String joinToString$default;
        TextView textView = this.mBinding.I;
        m mVar = m.f435564a;
        AssetManager assets = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
        textView.setTypeface(mVar.b(assets));
        TextView textView2 = this.mBinding.f419328z;
        AssetManager assets2 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets2, "context.assets");
        textView2.setTypeface(mVar.b(assets2));
        TextView textView3 = this.mBinding.f419303b0;
        AssetManager assets3 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets3, "context.assets");
        textView3.setTypeface(mVar.b(assets3));
        TextView textView4 = this.mBinding.Q;
        AssetManager assets4 = BaseApplication.context.getAssets();
        Intrinsics.checkNotNullExpressionValue(assets4, "context.assets");
        textView4.setTypeface(mVar.b(assets4));
        TextView textView5 = this.mBinding.I;
        Intrinsics.checkNotNullExpressionValue(textView5, "mBinding.followerNumTxv");
        TextView textView6 = this.mBinding.J;
        Intrinsics.checkNotNullExpressionValue(textView6, "mBinding.followerNumUnitTxv");
        s1(textView5, textView6, this.mData.f406359j);
        TextView textView7 = this.mBinding.f419328z;
        Intrinsics.checkNotNullExpressionValue(textView7, "mBinding.fansNumTxv");
        TextView textView8 = this.mBinding.A;
        Intrinsics.checkNotNullExpressionValue(textView8, "mBinding.fansNumUnitTxv");
        s1(textView7, textView8, this.mData.f406360k);
        TextView textView9 = this.mBinding.f419303b0;
        Intrinsics.checkNotNullExpressionValue(textView9, "mBinding.visitorsNumTxv");
        TextView textView10 = this.mBinding.f419305c0;
        Intrinsics.checkNotNullExpressionValue(textView10, "mBinding.visitorsNumUnitTxv");
        s1(textView9, textView10, this.mData.f406361l);
        TextView textView11 = this.mBinding.Q;
        Intrinsics.checkNotNullExpressionValue(textView11, "mBinding.likeNumTxv");
        TextView textView12 = this.mBinding.R;
        Intrinsics.checkNotNullExpressionValue(textView12, "mBinding.likeNumUnitTxv");
        s1(textView11, textView12, this.mData.C);
        LinearLayout linearLayout = this.mBinding.H;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.followerNumArea");
        aa.f(linearLayout, new View.OnClickListener() { // from class: nc4.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.d1(UserCenterInfoCard.this, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        LinearLayout linearLayout2 = this.mBinding.H;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "mBinding.followerNumArea");
        zplanViewReportHelper.g(linearLayout2, "em_zplan_follow_entrance_btn", (r16 & 4) != 0 ? null : null, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        if (this.userCenterPage.Qa() && this.mData.B > 0) {
            this.mBinding.f419326x.setVisibility(0);
            TextView textView13 = this.mBinding.f419326x;
            joinToString$default = ArraysKt___ArraysKt.joinToString$default(CommonExKt.d(this.mData.B), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            textView13.setText(Marker.ANY_NON_NULL_MARKER + joinToString$default);
        } else {
            this.mBinding.f419326x.setVisibility(8);
        }
        LinearLayout linearLayout3 = this.mBinding.f419327y;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "mBinding.fansNumArea");
        aa.f(linearLayout3, new View.OnClickListener() { // from class: nc4.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.a1(UserCenterInfoCard.this, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        ZplanViewReportHelper zplanViewReportHelper2 = this.mReporter;
        LinearLayout linearLayout4 = this.mBinding.f419327y;
        Intrinsics.checkNotNullExpressionValue(linearLayout4, "mBinding.fansNumArea");
        zplanViewReportHelper2.g(linearLayout4, "em_zplan_fans_entrance_btn", (r16 & 4) != 0 ? null : M0(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        LinearLayout linearLayout5 = this.mBinding.f419301a0;
        Intrinsics.checkNotNullExpressionValue(linearLayout5, "mBinding.visitorNumArea");
        aa.f(linearLayout5, new View.OnClickListener() { // from class: nc4.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.b1(UserCenterInfoCard.this, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        LinearLayout linearLayout6 = this.mBinding.P;
        Intrinsics.checkNotNullExpressionValue(linearLayout6, "mBinding.likeNumArea");
        aa.f(linearLayout6, new View.OnClickListener() { // from class: nc4.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.c1(UserCenterInfoCard.this, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        ZplanViewReportHelper zplanViewReportHelper3 = this.mReporter;
        LinearLayout linearLayout7 = this.mBinding.P;
        Intrinsics.checkNotNullExpressionValue(linearLayout7, "mBinding.likeNumArea");
        zplanViewReportHelper3.g(linearLayout7, "em_zplan_get_like", (r16 & 4) != 0 ? null : M0(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(UserCenterInfoCard this$0, View view) {
        g gVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        g[] gVarArr = this$0.mData.f406370u.f406377a;
        Intrinsics.checkNotNullExpressionValue(gVarArr, "mData.privacyList.privacyList");
        int length = gVarArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                gVar = null;
                break;
            }
            gVar = gVarArr[i3];
            if (gVar.f406375a == 0) {
                break;
            } else {
                i3++;
            }
        }
        boolean z16 = gVar != null && gVar.f406376b == 0;
        if (this$0.userCenterPage.j8() && !z16) {
            QQToast.makeText(this$0.getContext(), this$0.getContext().getResources().getString(R.string.xou), 0).show();
            return;
        }
        QRouteApi api = QRoute.api(IEntryApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IEntryApi::class.java)");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        IEntryApi.a.a((IEntryApi) api, context, this$0.userCenterPage.H1(), this$0.userCenterPage.getMCurrentUin(), 2, null, 16, null);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        LinearLayout linearLayout = this$0.mBinding.f419327y;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.fansNumArea");
        zplanViewReportHelper.e(linearLayout, "em_zplan_fans_entrance_btn", this$0.M0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(UserCenterInfoCard this$0, View view) {
        String joinToString$default;
        String joinToString$default2;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(CommonExKt.d(this$0.mData.f406361l), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        joinToString$default2 = ArraysKt___ArraysKt.joinToString$default(CommonExKt.d(this$0.mData.A), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        String string = this$0.getContext().getResources().getString(R.string.xuu, joinToString$default, joinToString$default2);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026lVisitNum, todayVisitNum)");
        if (this$0.userCenterPage.Qa()) {
            str = "\u6211";
        } else {
            str = "TA";
        }
        String str2 = str + string;
        aj ajVar = aj.f373263a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ajVar.b(context, str2, R.drawable.imm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c1(UserCenterInfoCard this$0, View view) {
        String joinToString$default;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(CommonExKt.d(this$0.mData.C), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        String string = this$0.getContext().getResources().getString(R.string.xut, joinToString$default);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026_like_tips, totalLikeNum)");
        if (this$0.userCenterPage.Qa()) {
            str = "\u6211";
        } else {
            str = "TA";
        }
        String str2 = str + string;
        aj ajVar = aj.f373263a;
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ajVar.b(context, str2, R.drawable.iiy);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        LinearLayout linearLayout = this$0.mBinding.P;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.likeNumArea");
        ZplanViewReportHelper.f(zplanViewReportHelper, linearLayout, "em_zplan_get_like", null, 4, null);
    }

    private final void e1() {
        URLDrawable.URLDrawableOptions circleOption = URLDrawable.URLDrawableOptions.obtain();
        circleOption.mLoadingDrawable = ContextCompat.getDrawable(getContext(), R.drawable.f159932ij1);
        circleOption.mFailedDrawable = ContextCompat.getDrawable(getContext(), R.drawable.f159932ij1);
        URLImageView uRLImageView = this.mBinding.f419302b;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.avatarCircleIgv");
        String str = this.mData.f406363n;
        Intrinsics.checkNotNullExpressionValue(str, "mData.avatarFrame");
        Intrinsics.checkNotNullExpressionValue(circleOption, "circleOption");
        CommonExKt.x(uRLImageView, str, circleOption, null, 4, null);
        Drawable b16 = q.b(R.drawable.gym);
        URLDrawable.URLDrawableOptions avatarOption = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = this.mBinding.f419304c.getDrawable();
        if (drawable == null) {
            drawable = b16;
        }
        avatarOption.mLoadingDrawable = drawable;
        avatarOption.mFailedDrawable = b16;
        this.mBinding.f419304c.setRadius(i.e(37));
        RoundCornerImageView roundCornerImageView = this.mBinding.f419304c;
        Intrinsics.checkNotNullExpressionValue(roundCornerImageView, "mBinding.avatarIgv");
        String str2 = this.mData.f406362m;
        Intrinsics.checkNotNullExpressionValue(str2, "mData.avatar");
        Intrinsics.checkNotNullExpressionValue(avatarOption, "avatarOption");
        CommonExKt.x(roundCornerImageView, str2, avatarOption, null, 4, null);
        m1("ev_zplan_avatar_edit_entrance", "imp");
        FrameLayout frameLayout = this.mBinding.X;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "mBinding.userAvatarArea");
        aa.d(frameLayout, new View.OnClickListener() { // from class: nc4.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.f1(UserCenterInfoCard.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(UserCenterInfoCard this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1("ev_zplan_avatar_edit_entrance", "click");
        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iSchemeApi.launchScheme(context, "mqqapi://zplan/openPage?src_type=app&version=1.0&referer=12&pageID=13&pageData=%7B%22backupUrl%22%3A%20%22https%3A%2F%2Fmweb.superqqshow.qq.com%2Fpages%2F20fe9bc4-qqshow%2Findex.html%3F_cwv%3D1%26_wv%3D1360078691%26_wwv%3D8192%22%7D");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g1(final int relationType) {
        this.mBinding.G.setVisibility(8);
        Object background = this.mBinding.G.getBackground();
        Animatable animatable = background instanceof Animatable ? (Animatable) background : null;
        if (animatable != null) {
            animatable.stop();
        }
        final HashMap hashMap = new HashMap();
        if (relationType != 0) {
            if (relationType == 1) {
                this.mBinding.F.setText(getContext().getString(R.string.xl7));
                this.mBinding.F.setCompoundDrawables(null, null, null, null);
                this.mBinding.D.setBackgroundResource(R.drawable.f159937i71);
                this.mBinding.E.setVisibility(4);
                hashMap.put("zplan_follow_status", 0);
            } else if (relationType != 2) {
                if (relationType == 3) {
                    this.mBinding.F.setText(getContext().getString(R.string.xoy));
                    this.mBinding.F.setCompoundDrawables(null, null, null, null);
                    this.mBinding.D.setBackgroundResource(R.drawable.f159937i71);
                    this.mBinding.E.setVisibility(4);
                    hashMap.put("zplan_follow_status", 0);
                }
            }
            final String str = "em_zplan_follow";
            RelativeLayout relativeLayout = this.mBinding.D;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "mBinding.followContainer");
            aa.f(relativeLayout, new View.OnClickListener() { // from class: nc4.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserCenterInfoCard.h1(UserCenterInfoCard.this, relationType, str, hashMap, view);
                }
            }, 500L, this.userCenterPage.getMCurrentUin());
            ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
            TextView textView = this.mBinding.F;
            Intrinsics.checkNotNullExpressionValue(textView, "mBinding.followTxv");
            zplanViewReportHelper.g(textView, "em_zplan_follow", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        }
        this.mBinding.F.setText(getContext().getString(R.string.xox));
        this.mBinding.F.setCompoundDrawablePadding(i.b(4));
        Drawable drawable = AppCompatResources.getDrawable(getContext(), R.drawable.f159897ig3);
        if (drawable != null) {
            drawable.setBounds(0, 0, i.b(18), i.b(18));
        }
        this.mBinding.F.setCompoundDrawables(drawable, null, null, null);
        this.mBinding.D.setBackgroundResource(R.drawable.i6z);
        this.mBinding.E.setVisibility(0);
        hashMap.put("zplan_follow_status", 1);
        final String str2 = "em_zplan_follow";
        RelativeLayout relativeLayout2 = this.mBinding.D;
        Intrinsics.checkNotNullExpressionValue(relativeLayout2, "mBinding.followContainer");
        aa.f(relativeLayout2, new View.OnClickListener() { // from class: nc4.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterInfoCard.h1(UserCenterInfoCard.this, relationType, str2, hashMap, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        ZplanViewReportHelper zplanViewReportHelper2 = this.mReporter;
        TextView textView2 = this.mBinding.F;
        Intrinsics.checkNotNullExpressionValue(textView2, "mBinding.followTxv");
        zplanViewReportHelper2.g(textView2, "em_zplan_follow", (r16 & 4) != 0 ? null : hashMap, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(UserCenterInfoCard this$0, int i3, String elementId, HashMap params, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(elementId, "$elementId");
        Intrinsics.checkNotNullParameter(params, "$params");
        this$0.N0(i3);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        TextView textView = this$0.mBinding.F;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.followTxv");
        zplanViewReportHelper.e(textView, elementId, params);
    }

    private final void i1() {
        String str = this.mData.f406358i;
        if (str == null || str.length() == 0) {
            this.mData.f406358i = getContext().getString(R.string.f169842xx0);
        }
        this.mBinding.Z.setVisibility(0);
        this.mBinding.V.setText(this.mData.f406358i);
    }

    private final void k1() {
        e1();
        U0();
        Z0();
        V0();
        T0();
        i1();
        VideoReport.traversePage(this.mBinding.getMContainer());
    }

    private final void l1(int resId) {
        this.mBinding.f419321s.setVisibility(0);
        this.mBinding.f419322t.setVisibility(0);
        this.mBinding.f419323u.setImageResource(resId);
        this.mBinding.f419324v.setText(getContext().getString(R.string.f169846xx4));
    }

    private final void m1(String eventId, String actionType) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put("zplan_avatar_edit_entrance", "12");
        hashMap.put("zplan_action_type", actionType);
        VideoReport.reportEvent(eventId, hashMap);
    }

    private final void o1() {
        this.mBinding.f419320r.setVisibility(0);
        this.mBinding.C.setVisibility(0);
        this.mBinding.f419311i.setVisibility(8);
        g1(this.mData.f406366q);
        this.mBinding.f419321s.setVisibility(8);
        this.mBinding.f419322t.setVisibility(8);
    }

    private final void p1() {
        this.mBinding.f419311i.setVisibility(0);
        this.mBinding.C.setVisibility(8);
        this.mBinding.f419320r.setVisibility(0);
        this.mBinding.f419312j.setImageResource(R.drawable.imo);
        this.mBinding.f419307e.setVisibility(8);
        this.mBinding.f419318p.setVisibility(8);
        l1(R.drawable.imp);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new Runnable() { // from class: nc4.b
            @Override // java.lang.Runnable
            public final void run() {
                UserCenterInfoCard.S0();
            }
        });
    }

    @Override // nc4.a
    public void w0(UserCenterCardData data, int position) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getPersonalInfo() != null) {
            this.mData = data.getPersonalInfo();
            k1();
        }
    }

    private final void s1(TextView numTxv, TextView unitTxv, int number) {
        String[] d16 = CommonExKt.d(number);
        numTxv.setText(d16[0]);
        unitTxv.setText(d16[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(UserCenterInfoCard this$0, View view) {
        g[] gVarArr;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hu4.h hVar = this$0.mData.f406370u;
        g gVar = null;
        if (hVar != null && (gVarArr = hVar.f406377a) != null) {
            int length = gVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                g gVar2 = gVarArr[i3];
                if (gVar2.f406375a == 0) {
                    gVar = gVar2;
                    break;
                }
                i3++;
            }
        }
        boolean z16 = gVar != null && gVar.f406376b == 0;
        if (this$0.userCenterPage.j8() && !z16) {
            QQToast.makeText(this$0.getContext(), this$0.getContext().getResources().getString(R.string.xoz), 0).show();
            return;
        }
        QRouteApi api = QRoute.api(IEntryApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IEntryApi::class.java)");
        Context context = this$0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        IEntryApi.a.a((IEntryApi) api, context, this$0.userCenterPage.H1(), this$0.userCenterPage.getMCurrentUin(), 1, null, 16, null);
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        LinearLayout linearLayout = this$0.mBinding.H;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "mBinding.followerNumArea");
        ZplanViewReportHelper.f(zplanViewReportHelper, linearLayout, "em_zplan_follow_entrance_btn", null, 4, null);
    }
}
