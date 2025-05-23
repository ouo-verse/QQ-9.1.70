package com.qzone.reborn.userhome.header;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.common.account.LoginData;
import com.qzone.personalize.model.CustomNaviCacheData;
import com.qzone.proxy.personalitycomponent.PersonalityComponentProxy;
import com.qzone.reborn.feedx.util.k;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.reborn.userhome.header.QZoneUserHomeNaviBar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.g;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.cn;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.ProcessUtils;
import ef.d;
import ho.e;
import ho.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import vo.b;
import x6.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \b2\u00020\u0001:\u0001SB'\b\u0007\u0012\u0006\u0010M\u001a\u00020L\u0012\n\b\u0002\u0010O\u001a\u0004\u0018\u00010N\u0012\b\b\u0002\u0010P\u001a\u00020$\u00a2\u0006\u0004\bQ\u0010RJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0002H\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010!\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u0002H\u0002J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020\u0002H\u0002J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\rJ\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020 J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u0012\u00100\u001a\u00020\u00022\b\u0010/\u001a\u0004\u0018\u00010.H\u0016J\u000e\u00102\u001a\u00020\u00022\u0006\u00101\u001a\u00020$J\u0012\u00105\u001a\u00020\u00022\b\u00104\u001a\u0004\u0018\u000103H\u0014R\u0016\u00107\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010,R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010,R\u0016\u0010?\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010-R\u0018\u0010A\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010@R\u0016\u0010C\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010BR\u0016\u0010D\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010BR\u0016\u0010E\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010BR\u0016\u0010F\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010BR\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u0010BR\u001c\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006T"}, d2 = {"Lcom/qzone/reborn/userhome/header/QZoneUserHomeNaviBar;", "Landroid/widget/LinearLayout;", "", "w", "L", "Lcom/qzone/reborn/userhome/header/QZoneUserHomeNaviItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "M", "H", "Lcom/qzone/personalize/model/CustomNaviCacheData;", "data", "E", UserInfo.SEX_FEMALE, "Lx6/a;", "k", "l", "i", "j", "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", HippyTKDListViewAdapter.X, "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "N", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "o", "naviItem", "g", "B", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "K", "", "radius", "Landroid/graphics/drawable/GradientDrawable;", DomainData.DOMAIN_NAME, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "P", "hasStrangerDecorate", "I", "J", "Landroid/graphics/drawable/Drawable;", "background", "setBackground", c.f123400v, h.F, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "d", "mBackgroundAlpha", "", "e", "Ljava/lang/String;", "mProfileNaviUrl", "f", "mNaviStyle", "", "mUin", "Lx6/a;", "mUserInfoData", "Lcom/qzone/reborn/userhome/header/QZoneUserHomeNaviItem;", "mMoodItem", "mBlogItem", "mPhotoItem", "mMessageItem", "mVisitorItem", "", "G", "Ljava/util/List;", "mItemList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneUserHomeNaviBar extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private QZoneUserHomeNaviItem mBlogItem;

    /* renamed from: D, reason: from kotlin metadata */
    private QZoneUserHomeNaviItem mPhotoItem;

    /* renamed from: E, reason: from kotlin metadata */
    private QZoneUserHomeNaviItem mMessageItem;

    /* renamed from: F, reason: from kotlin metadata */
    private QZoneUserHomeNaviItem mVisitorItem;

    /* renamed from: G, reason: from kotlin metadata */
    private List<QZoneUserHomeNaviItem> mItemList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mBackgroundAlpha;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mProfileNaviUrl;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mNaviStyle;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mUin;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private a mUserInfoData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneUserHomeNaviItem mMoodItem;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneUserHomeNaviBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean A() {
        return k.E(this.mUserInfoData) && !k.G(this.mUserInfoData);
    }

    private final void B() {
        String str;
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = this.mBlogItem;
        if (qZoneUserHomeNaviItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneUserHomeNaviItem = null;
        }
        if (qZoneUserHomeNaviItem.f()) {
            str = "1";
        } else {
            str = "2";
        }
        String str2 = str;
        a aVar = this.mUserInfoData;
        long j3 = aVar != null ? aVar.uin : 0L;
        if (z()) {
            LpReportInfo_pf00064.allReport(308, 3, 0, str2, j3);
        } else {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 3, 2, str2, j3);
        }
        com.qzone.misc.network.report.a.b();
    }

    private final void C() {
        if (z()) {
            LpReportInfo_pf00064.allReport(308, 2, 0);
        } else {
            LpReportInfo_pf00064.allReport(308, 2, 4);
        }
        com.qzone.misc.network.report.a.m();
    }

    private final void E(CustomNaviCacheData data) {
        F(data);
        int i3 = (int) data.btnTextColor;
        int i16 = (int) data.profileDescTextColor;
        Iterator<T> it = this.mItemList.iterator();
        while (it.hasNext()) {
            ((QZoneUserHomeNaviItem) it.next()).setTextColor(i3, i16);
        }
    }

    private final void F(CustomNaviCacheData data) {
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(data.profileNaviUrl), new IPicLoadStateListener() { // from class: mo.o
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneUserHomeNaviBar.G(QZoneUserHomeNaviBar.this, loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(QZoneUserHomeNaviBar this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (loadState == null || !loadState.isFinishSuccess() || option.getResultBitMap() == null) {
            return;
        }
        g.a(this$0, new BitmapDrawable(this$0.getContext().getResources(), option.getResultBitMap()));
    }

    private final void H() {
        D();
        Iterator<T> it = this.mItemList.iterator();
        while (it.hasNext()) {
            ((QZoneUserHomeNaviItem) it.next()).setDefaultTextColor();
        }
    }

    private final void K(a data) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = this.mMoodItem;
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = null;
        if (qZoneUserHomeNaviItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneUserHomeNaviItem = null;
        }
        qZoneUserHomeNaviItem.setCount(data.shuoshuoCount);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mBlogItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneUserHomeNaviItem3 = null;
        }
        qZoneUserHomeNaviItem3.setCount(data.blogCount);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mPhotoItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneUserHomeNaviItem4 = null;
        }
        qZoneUserHomeNaviItem4.setCount(data.photoCount);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem5 = this.mMessageItem;
        if (qZoneUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneUserHomeNaviItem5 = null;
        }
        qZoneUserHomeNaviItem5.setCount(data.messageCount);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem6 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
        } else {
            qZoneUserHomeNaviItem2 = qZoneUserHomeNaviItem6;
        }
        qZoneUserHomeNaviItem2.setCount(data.visitorCount);
    }

    private final void L() {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = this.mMoodItem;
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = null;
        if (qZoneUserHomeNaviItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneUserHomeNaviItem = null;
        }
        M(qZoneUserHomeNaviItem);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mBlogItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneUserHomeNaviItem3 = null;
        }
        M(qZoneUserHomeNaviItem3);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mPhotoItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneUserHomeNaviItem4 = null;
        }
        M(qZoneUserHomeNaviItem4);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem5 = this.mMessageItem;
        if (qZoneUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneUserHomeNaviItem5 = null;
        }
        M(qZoneUserHomeNaviItem5);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem6 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
        } else {
            qZoneUserHomeNaviItem2 = qZoneUserHomeNaviItem6;
        }
        M(qZoneUserHomeNaviItem2);
    }

    private final void M(QZoneUserHomeNaviItem item) {
        item.setVisibility(k.G(this.mUserInfoData) ? 0 : 8);
    }

    private final void N() {
        u5.c.I("photo_red_dot_sp" + this.mUin, System.currentTimeMillis() / 1000, LoginData.getInstance().getUin());
    }

    private final void O() {
        Iterator<T> it = this.mItemList.iterator();
        while (it.hasNext()) {
            ((QZoneUserHomeNaviItem) it.next()).getLayoutParams().width = pl.a.f426446a.o(getContext()) / 5;
        }
    }

    private final void g(QZoneUserHomeNaviItem naviItem, LinearLayout.LayoutParams layoutParams) {
        addView(naviItem, layoutParams);
        this.mItemList.add(naviItem);
    }

    private final void i(a data) {
        String str;
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = null;
        if (data.blogRedCount > 0) {
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mBlogItem;
            if (qZoneUserHomeNaviItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            } else {
                qZoneUserHomeNaviItem = qZoneUserHomeNaviItem2;
            }
            qZoneUserHomeNaviItem.j();
            str = "1";
        } else {
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mBlogItem;
            if (qZoneUserHomeNaviItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            } else {
                qZoneUserHomeNaviItem = qZoneUserHomeNaviItem3;
            }
            qZoneUserHomeNaviItem.d();
            str = "2";
        }
        String str2 = str;
        if (z()) {
            LpReportInfo_pf00064.allReport(308, 3, 1, str2, this.mUin);
        } else {
            LpReportInfo_pf00064.allReport(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST, 3, 1, str2, this.mUin);
        }
    }

    private final void j(a data) {
        boolean o16 = dh.a.f393805d.o();
        QLog.i("QZ_QFS_QZoneUserHomeNaviBar", 1, "checkPhotoRedDot, showAlbumEntranceRedDot=" + o16);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = null;
        if (data.uin == LoginData.getInstance().getUin() && (data.albumRedCount > 0 || o16)) {
            LpReportInfo_pf00064.allReport(308, 2, 3);
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mPhotoItem;
            if (qZoneUserHomeNaviItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            } else {
                qZoneUserHomeNaviItem = qZoneUserHomeNaviItem2;
            }
            qZoneUserHomeNaviItem.j();
            return;
        }
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mPhotoItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
        } else {
            qZoneUserHomeNaviItem = qZoneUserHomeNaviItem3;
        }
        qZoneUserHomeNaviItem.d();
    }

    private final void k(a data) {
        j(data);
        i(data);
        l(data);
    }

    private final void l(a data) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = null;
        if (z() && data.visitorNewCount > 0) {
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mVisitorItem;
            if (qZoneUserHomeNaviItem2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
                qZoneUserHomeNaviItem2 = null;
            }
            qZoneUserHomeNaviItem2.setRedDotNum(data.visitorNewCount);
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mVisitorItem;
            if (qZoneUserHomeNaviItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
            } else {
                qZoneUserHomeNaviItem = qZoneUserHomeNaviItem3;
            }
            qZoneUserHomeNaviItem.j();
            return;
        }
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
        } else {
            qZoneUserHomeNaviItem = qZoneUserHomeNaviItem4;
        }
        qZoneUserHomeNaviItem.d();
    }

    private final Activity m() {
        if (getContext() instanceof Activity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            return (Activity) context;
        }
        return ProcessUtils.getTopActivity();
    }

    private final void o(LinearLayout.LayoutParams layoutParams) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = new QZoneUserHomeNaviItem(getContext());
        this.mBlogItem = qZoneUserHomeNaviItem;
        qZoneUserHomeNaviItem.setName(R.string.f170632wl);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mBlogItem;
        if (qZoneUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneUserHomeNaviItem2 = null;
        }
        qZoneUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeNaviBar.p(QZoneUserHomeNaviBar.this, view);
            }
        });
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mBlogItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneUserHomeNaviItem3 = null;
        }
        g(qZoneUserHomeNaviItem3, layoutParams);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mBlogItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneUserHomeNaviItem4 = null;
        }
        fo.c.o(qZoneUserHomeNaviItem4, "em_qz_log_button", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(QZoneUserHomeNaviBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mUserInfoData;
        if (aVar != null && aVar != null) {
            Context context = this$0.getContext();
            a aVar2 = this$0.mUserInfoData;
            Intrinsics.checkNotNull(aVar2);
            long j3 = aVar2.uin;
            a aVar3 = this$0.mUserInfoData;
            Intrinsics.checkNotNull(aVar3);
            b.g(context, j3, aVar3.name, "getMainPage");
            this$0.B();
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem = this$0.mBlogItem;
            if (qZoneUserHomeNaviItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
                qZoneUserHomeNaviItem = null;
            }
            qZoneUserHomeNaviItem.d();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void q(LinearLayout.LayoutParams layoutParams) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = new QZoneUserHomeNaviItem(getContext());
        this.mMessageItem = qZoneUserHomeNaviItem;
        qZoneUserHomeNaviItem.setName(R.string.c89);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mMessageItem;
        if (qZoneUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneUserHomeNaviItem2 = null;
        }
        qZoneUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeNaviBar.r(QZoneUserHomeNaviBar.this, view);
            }
        });
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mMessageItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneUserHomeNaviItem3 = null;
        }
        g(qZoneUserHomeNaviItem3, layoutParams);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mMessageItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneUserHomeNaviItem4 = null;
        }
        fo.c.o(qZoneUserHomeNaviItem4, "em_qz_message_button", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QZoneUserHomeNaviBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserInfoData != null) {
            i.z().l(this$0.getContext(), this$0.mUin);
            LpReportInfo_pf00064.allReport(308, 5, 0);
            com.qzone.misc.network.report.a.i();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s(LinearLayout.LayoutParams layoutParams) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = new QZoneUserHomeNaviItem(getContext());
        this.mMoodItem = qZoneUserHomeNaviItem;
        qZoneUserHomeNaviItem.setName(R.string.caf);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mMoodItem;
        if (qZoneUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneUserHomeNaviItem2 = null;
        }
        qZoneUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeNaviBar.t(QZoneUserHomeNaviBar.this, view);
            }
        });
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mMoodItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneUserHomeNaviItem3 = null;
        }
        g(qZoneUserHomeNaviItem3, layoutParams);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mMoodItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneUserHomeNaviItem4 = null;
        }
        fo.c.o(qZoneUserHomeNaviItem4, "em_qz_talk_about", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(QZoneUserHomeNaviBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.mUserInfoData;
        if (aVar != null && aVar != null) {
            e j3 = i.j();
            Context context = this$0.getContext();
            a aVar2 = this$0.mUserInfoData;
            Intrinsics.checkNotNull(aVar2);
            long j16 = aVar2.uin;
            a aVar3 = this$0.mUserInfoData;
            Intrinsics.checkNotNull(aVar3);
            String str = aVar3.name;
            Intrinsics.checkNotNullExpressionValue(str, "mUserInfoData!!.name");
            j3.b(context, new QZoneMoodListInitBean(j16, str, "getMainPage"));
            LpReportInfo_pf00064.allReport(308, 4, 0);
            com.qzone.misc.network.report.a.j();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u(LinearLayout.LayoutParams layoutParams) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = new QZoneUserHomeNaviItem(getContext());
        this.mPhotoItem = qZoneUserHomeNaviItem;
        qZoneUserHomeNaviItem.setName(R.string.ty5);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mPhotoItem;
        if (qZoneUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneUserHomeNaviItem2 = null;
        }
        qZoneUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeNaviBar.v(QZoneUserHomeNaviBar.this, view);
            }
        });
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mPhotoItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneUserHomeNaviItem3 = null;
        }
        g(qZoneUserHomeNaviItem3, layoutParams);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mPhotoItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneUserHomeNaviItem4 = null;
        }
        fo.c.o(qZoneUserHomeNaviItem4, "em_qz_album", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QZoneUserHomeNaviBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserInfoData != null) {
            b.f(this$0.getContext(), this$0.mUin, "getMainPage");
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem = this$0.mPhotoItem;
            if (qZoneUserHomeNaviItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
                qZoneUserHomeNaviItem = null;
            }
            qZoneUserHomeNaviItem.d();
            a aVar = this$0.mUserInfoData;
            if (aVar != null && aVar.uin == LoginData.getInstance().getUin()) {
                dh.a aVar2 = dh.a.f393805d;
                if (aVar2.o()) {
                    aVar2.j(false);
                }
            }
            this$0.N();
            this$0.C();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void w() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pl.a.f426446a.o(getContext()) / 5, -1);
        s(layoutParams);
        o(layoutParams);
        u(layoutParams);
        q(layoutParams);
        x(layoutParams);
    }

    private final void x(LinearLayout.LayoutParams layoutParams) {
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem = new QZoneUserHomeNaviItem(getContext());
        this.mVisitorItem = qZoneUserHomeNaviItem;
        qZoneUserHomeNaviItem.setName(R.string.if9);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem2 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
            qZoneUserHomeNaviItem2 = null;
        }
        qZoneUserHomeNaviItem2.setShowRedDotInNumStyle(true);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem3 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
            qZoneUserHomeNaviItem3 = null;
        }
        qZoneUserHomeNaviItem3.setOnClickListener(new View.OnClickListener() { // from class: mo.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneUserHomeNaviBar.y(QZoneUserHomeNaviBar.this, view);
            }
        });
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem4 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
            qZoneUserHomeNaviItem4 = null;
        }
        g(qZoneUserHomeNaviItem4, layoutParams);
        QZoneUserHomeNaviItem qZoneUserHomeNaviItem5 = this.mVisitorItem;
        if (qZoneUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
            qZoneUserHomeNaviItem5 = null;
        }
        fo.c.o(qZoneUserHomeNaviItem5, "em_qz_visitor_button", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(QZoneUserHomeNaviBar this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserInfoData != null) {
            i.z().w(this$0.m(), this$0.mUin);
            QZoneUserHomeNaviItem qZoneUserHomeNaviItem = this$0.mVisitorItem;
            if (qZoneUserHomeNaviItem == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVisitorItem");
                qZoneUserHomeNaviItem = null;
            }
            qZoneUserHomeNaviItem.d();
            PersonalityComponentProxy.f50957g.getServiceInterface().clearVisitorListCache();
            a aVar = this$0.mUserInfoData;
            Intrinsics.checkNotNull(aVar);
            if (aVar.visitorNewCount > 0) {
                str = "1";
            } else {
                str = "0";
            }
            LpReportInfo_pf00064.allReport(308, 13, 0, str);
            com.qzone.misc.network.report.a.o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean z() {
        a aVar = this.mUserInfoData;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            if (aVar.uin == LoginData.getInstance().getUin()) {
                return true;
            }
        }
        return false;
    }

    public final void I(boolean hasStrangerDecorate) {
        if (getBackground() == null) {
            return;
        }
        if (hasStrangerDecorate) {
            com.qzone.reborn.feedx.widget.i.a(this, 0);
        } else {
            com.qzone.reborn.feedx.widget.i.a(this, this.mBackgroundAlpha);
        }
    }

    public final void J(CustomNaviCacheData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (com.qzone.personalize.business.b.q(data)) {
            if (this.mNaviStyle == 2 && TextUtils.equals(this.mProfileNaviUrl, data.profileNaviUrl)) {
                return;
            }
            this.mNaviStyle = 2;
            String str = data.profileNaviUrl;
            Intrinsics.checkNotNullExpressionValue(str, "data.profileNaviUrl");
            this.mProfileNaviUrl = str;
            E(data);
            return;
        }
        if (this.mNaviStyle != 1) {
            this.mNaviStyle = 1;
            H();
        }
    }

    public final void P(a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.mUserInfoData = data;
        L();
        this.mUin = data.uin;
        K(data);
        k(data);
        I(A());
    }

    public final void h(int alpha) {
        this.mBackgroundAlpha = alpha;
        com.qzone.reborn.feedx.widget.i.a(this, alpha);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (com.qzone.reborn.configx.g.f53821a.b().J1()) {
            O();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneUserHomeNaviBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final GradientDrawable n(int radius) {
        float f16 = radius;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getContext().getColor(R.color.qui_common_fill_light_primary));
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    public /* synthetic */ QZoneUserHomeNaviBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void D() {
        setBackground(n(d.b(20)));
    }

    @Override // android.view.View
    public void setBackground(Drawable background) {
        if (background != null) {
            Drawable f16 = cn.f(background);
            if (!A()) {
                f16.setAlpha(this.mBackgroundAlpha);
            } else {
                f16.setAlpha(0);
            }
        }
        super.setBackground(background);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneUserHomeNaviBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mBackgroundAlpha = 255;
        this.mProfileNaviUrl = "";
        this.mItemList = new ArrayList();
        D();
        w();
    }
}
