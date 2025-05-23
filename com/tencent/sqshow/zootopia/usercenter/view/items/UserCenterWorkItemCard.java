package com.tencent.sqshow.zootopia.usercenter.view.items;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import aw4.c;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.usercenter.view.items.UserCenterWorkItemCard;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.aa;
import com.tencent.sqshow.zootopia.utils.e;
import com.tencent.sqshow.zootopia.utils.i;
import com.tencent.sqshow.zootopia.utils.q;
import com.tencent.util.URLUtil;
import java.io.File;
import java.util.Map;
import jc4.UserCenterCardData;
import jc4.UserWorkItemData;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m84.b;
import n74.bj;
import nc4.a;
import pu4.g;
import pv4.s;
import pv4.u;
import t74.m;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0017\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u001e\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001aR\u001c\u0010\u001f\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*\u00a8\u00062"}, d2 = {"Lcom/tencent/sqshow/zootopia/usercenter/view/items/UserCenterWorkItemCard;", "Landroid/widget/FrameLayout;", "Lnc4/a;", "", "url", "", "f", "Ljc4/h;", "itemData", "", "", "b", "Lpv4/u;", "indexText", "", "d", "e", "Ljc4/a;", "data", "", "position", "w0", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;", "userCenterPage", "Ln74/bj;", "Ln74/bj;", "mBinding", "Landroid/graphics/drawable/Drawable;", "kotlin.jvm.PlatformType", "Landroid/graphics/drawable/Drawable;", "mDefaultDrawable", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", h.F, "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "mReporter", "", "i", "J", "getLastModifiedTime", "()J", "setLastModifiedTime", "(J)V", "lastModifiedTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/usercenter/fragment/a;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class UserCenterWorkItemCard extends FrameLayout implements a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final bj mBinding;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Drawable mDefaultDrawable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZplanViewReportHelper mReporter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long lastModifiedTime;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCenterWorkItemCard(Context context, com.tencent.sqshow.zootopia.usercenter.fragment.a userCenterPage) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userCenterPage, "userCenterPage");
        this.userCenterPage = userCenterPage;
        bj g16 = bj.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.mBinding = g16;
        this.mDefaultDrawable = q.b(R.drawable.gym);
        this.mReporter = new ZplanViewReportHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(s itemData, UserCenterWorkItemCard this$0, UserCenterCardData data, int i3, View view) {
        Intrinsics.checkNotNullParameter(itemData, "$itemData");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        String str = itemData.f427682c;
        if (str != null) {
            ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iSchemeApi.launchScheme(context, str);
        }
        ZplanViewReportHelper zplanViewReportHelper = this$0.mReporter;
        ConstraintLayout root = this$0.mBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        zplanViewReportHelper.e(root, "em_zplan_opus", this$0.b(data.getWorkItemData()));
        QLog.d("UserCenterWorkItemCard", 1, "Current Work Item " + i3 + " ==> " + data.getWorkItemData().getUiData().f427682c);
    }

    private final void e(u indexText) {
        this.mBinding.f418845d.setTypeface(Typeface.defaultFromStyle(0));
        TextView textView = this.mBinding.f418845d;
        Intrinsics.checkNotNullExpressionValue(textView, "mBinding.zplanGoodsTvCurrency");
        b.h(textView, indexText);
    }

    public final void setLastModifiedTime(long j3) {
        this.lastModifiedTime = j3;
    }

    private final Map<String, Object> b(UserWorkItemData itemData) {
        Object obj;
        Map<String, Object> mutableMapOf;
        c statusData;
        c statusData2;
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("zplan_tab_id", "1");
        pairArr[1] = TuplesKt.to("zplan_tab_name", getContext().getString(R.string.f169843xx1));
        Object obj2 = "";
        if (itemData == null || (statusData2 = itemData.getStatusData()) == null) {
            obj = "";
        } else {
            obj = Long.valueOf(statusData2.f27096a);
        }
        pairArr[2] = TuplesKt.to("zplan_opus_id", obj);
        if (itemData != null && (statusData = itemData.getStatusData()) != null) {
            obj2 = Integer.valueOf(statusData.f27097b);
        }
        pairArr[3] = TuplesKt.to("zplan_opus_status", obj2);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void d(u indexText) {
        try {
            TextView textView = this.mBinding.f418845d;
            m mVar = m.f435564a;
            AssetManager assets = BaseApplication.context.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "context.assets");
            textView.setTypeface(mVar.b(assets));
            this.mBinding.f418845d.setText(e.f373267a.b(indexText.f427702a));
            String str = indexText.f427704c;
            if (str != null) {
                if (str.length() == 0) {
                    return;
                }
                this.mBinding.f418845d.setTextColor(Color.parseColor(str));
            }
        } catch (Exception e16) {
            QLog.e("UserCenterWorkItemCard", 1, "render currentcyNumber error " + e16);
        }
    }

    private final boolean f(String url) {
        if (url == null || URLUtil.isValidUrl(url)) {
            return true;
        }
        File file = new File(url);
        if (!file.exists()) {
            return true;
        }
        long lastModified = file.lastModified();
        long j3 = this.lastModifiedTime;
        if (lastModified == j3) {
            return true;
        }
        QLog.d("UserCenterWorkItemCard", 1, "Skip refresh image as file is`t modified " + lastModified + " ==> " + j3);
        this.lastModifiedTime = lastModified;
        return false;
    }

    @Override // nc4.a
    public void w0(final UserCenterCardData data, final int position) {
        final s uiData;
        Intrinsics.checkNotNullParameter(data, "data");
        UserWorkItemData workItemData = data.getWorkItemData();
        if (workItemData == null || (uiData = workItemData.getUiData()) == null) {
            return;
        }
        int c16 = (t74.u.INSTANCE.c(BaseApplication.context) - i.b(48)) / 3;
        int i3 = (int) (c16 * 0.7339449541284404d);
        int b16 = i.b(50) + i3;
        u uVar = uiData.f427683d;
        if (uVar != null) {
            if (e.f373267a.c(uVar.f427702a)) {
                d(uVar);
            } else {
                e(uVar);
            }
            URLImageView uRLImageView = this.mBinding.f418844c;
            Intrinsics.checkNotNullExpressionValue(uRLImageView, "mBinding.zplanGoodsIconCurrency");
            g gVar = uVar.f427705d;
            Drawable mDefaultDrawable = this.mDefaultDrawable;
            Intrinsics.checkNotNullExpressionValue(mDefaultDrawable, "mDefaultDrawable");
            CommonExKt.r(uRLImageView, gVar, mDefaultDrawable);
        }
        g gVar2 = uiData.f427681b;
        if (gVar2 != null) {
            ViewGroup.LayoutParams layoutParams = this.mBinding.f418843b.getLayoutParams();
            layoutParams.height = i3;
            layoutParams.width = i3;
            if (!f(gVar2.f427434a)) {
                this.mBinding.f418843b.K(false);
            } else {
                this.mBinding.f418843b.K(true);
            }
            this.mBinding.f418843b.e(gVar2);
            QLog.d("UserCenterWorkItemCard", 1, "play " + gVar2.f427434a);
        }
        ConstraintLayout root = this.mBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "mBinding.root");
        aa.f(root, new View.OnClickListener() { // from class: nc4.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UserCenterWorkItemCard.c(s.this, this, data, position, view);
            }
        }, 500L, this.userCenterPage.getMCurrentUin());
        this.mBinding.f418846e.setLayoutParams(new FrameLayout.LayoutParams(c16, b16));
        ZplanViewReportHelper zplanViewReportHelper = this.mReporter;
        ConstraintLayout root2 = this.mBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "mBinding.root");
        zplanViewReportHelper.g(root2, "em_zplan_opus", (r16 & 4) != 0 ? null : b(data.getWorkItemData()), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
    }
}
