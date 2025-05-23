package com.qzone.reborn.userhome.header;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.reborn.userhome.header.QZoneFamousUserHomeNaviBar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import fo.c;
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
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/userhome/header/QZoneFamousUserHomeNaviBar;", "Landroid/widget/LinearLayout;", "", DomainData.DOMAIN_NAME, "Landroid/widget/LinearLayout$LayoutParams;", "layoutParams", h.F, "l", "o", "j", "f", "Lcom/qzone/reborn/userhome/header/QZoneFamousUserHomeNaviItem;", "naviItem", "e", "p", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Lx6/a;", "data", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "d", "J", "mUin", "Lx6/a;", "mUserInfoData", "Lcom/qzone/reborn/userhome/header/QZoneFamousUserHomeNaviItem;", "mMoodItem", "mBlogItem", "i", "mPhotoItem", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mMessageItem", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mItemList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public class QZoneFamousUserHomeNaviBar extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private List<QZoneFamousUserHomeNaviItem> mItemList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private a mUserInfoData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneFamousUserHomeNaviItem mMoodItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneFamousUserHomeNaviItem mBlogItem;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneFamousUserHomeNaviItem mPhotoItem;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private QZoneFamousUserHomeNaviItem mMessageItem;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeNaviBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e(QZoneFamousUserHomeNaviItem naviItem, LinearLayout.LayoutParams layoutParams) {
        addView(naviItem, layoutParams);
        this.mItemList.add(naviItem);
    }

    private final void f(LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem = new QZoneFamousUserHomeNaviItem(context, null, 0, 6, null);
        this.mBlogItem = qZoneFamousUserHomeNaviItem;
        qZoneFamousUserHomeNaviItem.setName(R.string.f170632wl);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem2 = this.mBlogItem;
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem3 = null;
        if (qZoneFamousUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneFamousUserHomeNaviItem2 = null;
        }
        qZoneFamousUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeNaviBar.g(QZoneFamousUserHomeNaviBar.this, view);
            }
        });
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem4 = this.mBlogItem;
        if (qZoneFamousUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
            qZoneFamousUserHomeNaviItem4 = null;
        }
        e(qZoneFamousUserHomeNaviItem4, layoutParams);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem5 = this.mBlogItem;
        if (qZoneFamousUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBlogItem");
        } else {
            qZoneFamousUserHomeNaviItem3 = qZoneFamousUserHomeNaviItem5;
        }
        c.n(qZoneFamousUserHomeNaviItem3, "em_qz_aut_log_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(QZoneFamousUserHomeNaviBar this$0, View view) {
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
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void h(LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem = new QZoneFamousUserHomeNaviItem(context, null, 0, 6, null);
        this.mMessageItem = qZoneFamousUserHomeNaviItem;
        qZoneFamousUserHomeNaviItem.setName(R.string.c89);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem2 = this.mMessageItem;
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem3 = null;
        if (qZoneFamousUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneFamousUserHomeNaviItem2 = null;
        }
        qZoneFamousUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeNaviBar.i(QZoneFamousUserHomeNaviBar.this, view);
            }
        });
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem4 = this.mMessageItem;
        if (qZoneFamousUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
            qZoneFamousUserHomeNaviItem4 = null;
        }
        e(qZoneFamousUserHomeNaviItem4, layoutParams);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem5 = this.mMessageItem;
        if (qZoneFamousUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMessageItem");
        } else {
            qZoneFamousUserHomeNaviItem3 = qZoneFamousUserHomeNaviItem5;
        }
        c.n(qZoneFamousUserHomeNaviItem3, "em_qz_aut_message_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(QZoneFamousUserHomeNaviBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserInfoData != null) {
            i.z().l(this$0.getContext(), this$0.mUin);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void j(LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem = new QZoneFamousUserHomeNaviItem(context, null, 0, 6, null);
        this.mMoodItem = qZoneFamousUserHomeNaviItem;
        qZoneFamousUserHomeNaviItem.setName(R.string.caf);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem2 = this.mMoodItem;
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem3 = null;
        if (qZoneFamousUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneFamousUserHomeNaviItem2 = null;
        }
        qZoneFamousUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeNaviBar.k(QZoneFamousUserHomeNaviBar.this, view);
            }
        });
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem4 = this.mMoodItem;
        if (qZoneFamousUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
            qZoneFamousUserHomeNaviItem4 = null;
        }
        e(qZoneFamousUserHomeNaviItem4, layoutParams);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem5 = this.mMoodItem;
        if (qZoneFamousUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMoodItem");
        } else {
            qZoneFamousUserHomeNaviItem3 = qZoneFamousUserHomeNaviItem5;
        }
        c.n(qZoneFamousUserHomeNaviItem3, "em_qz_aut_talk_about");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(QZoneFamousUserHomeNaviBar this$0, View view) {
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
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void l(LinearLayout.LayoutParams layoutParams) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem = new QZoneFamousUserHomeNaviItem(context, null, 0, 6, null);
        this.mPhotoItem = qZoneFamousUserHomeNaviItem;
        qZoneFamousUserHomeNaviItem.setName(R.string.ty5);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem2 = this.mPhotoItem;
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem3 = null;
        if (qZoneFamousUserHomeNaviItem2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneFamousUserHomeNaviItem2 = null;
        }
        qZoneFamousUserHomeNaviItem2.setOnClickListener(new View.OnClickListener() { // from class: mo.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneFamousUserHomeNaviBar.m(QZoneFamousUserHomeNaviBar.this, view);
            }
        });
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem4 = this.mPhotoItem;
        if (qZoneFamousUserHomeNaviItem4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
            qZoneFamousUserHomeNaviItem4 = null;
        }
        e(qZoneFamousUserHomeNaviItem4, layoutParams);
        QZoneFamousUserHomeNaviItem qZoneFamousUserHomeNaviItem5 = this.mPhotoItem;
        if (qZoneFamousUserHomeNaviItem5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhotoItem");
        } else {
            qZoneFamousUserHomeNaviItem3 = qZoneFamousUserHomeNaviItem5;
        }
        c.n(qZoneFamousUserHomeNaviItem3, "em_qz_aut_album_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QZoneFamousUserHomeNaviBar this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mUserInfoData != null) {
            b.f(this$0.getContext(), this$0.mUin, "getMainPage");
            this$0.o();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(pl.a.f426446a.o(getContext()) / 4, -1);
        j(layoutParams);
        f(layoutParams);
        l(layoutParams);
        h(layoutParams);
    }

    private final void o() {
        u5.c.I("photo_red_dot_sp" + this.mUin, System.currentTimeMillis() / 1000, LoginData.getInstance().getUin());
    }

    private final void p() {
        Iterator<T> it = this.mItemList.iterator();
        while (it.hasNext()) {
            ((QZoneFamousUserHomeNaviItem) it.next()).getLayoutParams().width = pl.a.f426446a.o(getContext()) / 4;
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (g.f53821a.b().J1()) {
            p();
        }
    }

    public final void q(a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        this.mUserInfoData = data;
        this.mUin = data.uin;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeNaviBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneFamousUserHomeNaviBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFamousUserHomeNaviBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mItemList = new ArrayList();
        n();
    }
}
