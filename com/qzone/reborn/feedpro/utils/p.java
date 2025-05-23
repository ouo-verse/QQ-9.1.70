package com.qzone.reborn.feedpro.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.qzone.util.ar;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.util.RFWNetworkUtils;
import com.tencent.hippy.qq.module.HippyQQHttpModule;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.MainPageControl;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.Questions;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.QzoneRightQuestion;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b\u001a\"\u0010\u000f\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f\u001a\n\u0010\u0010\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0011\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0012\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0013\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0014\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0015\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0016\u001a\u00020\b*\u00020\u000b\u001a\n\u0010\u0017\u001a\u00020\u0002*\u00020\u000b\u001a\u001a\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\f0\u0019j\b\u0012\u0004\u0012\u00020\f`\u001a*\u00020\u0018\u001a\u0016\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\f\u001a\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\f\u001a\u000e\u0010!\u001a\u00020 2\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0018\u0010$\u001a\u00020#2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\"\u001a\u00020\u0002\u001a\u0018\u0010%\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\"\u001a\u00020\u0002\u001a\u001e\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b\u001a\u001e\u00100\u001a\u00020/2\u0006\u0010+\u001a\u00020*2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\f\u001a\u0010\u00102\u001a\u00020\b2\b\u00101\u001a\u0004\u0018\u00010\f\u00a8\u00063"}, d2 = {"Landroid/content/Context;", "context", "", "errorCode", "Luc/a;", "b", "d", "c", "", "isMaster", "e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/MainPageControl;", "", "title", "desc", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "t", "r", "v", "w", "p", ReportConstant.COSTREPORT_PREFIX, "o", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", HippyTKDListViewAdapter.X, TuxUIConstants.POP_BTN_TEXT, "Landroid/widget/TextView;", "j", "k", "Landroid/widget/FrameLayout;", "i", "btnNum", "Landroid/widget/LinearLayout$LayoutParams;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "hasBrowserPermission", "needQuestion", "needShowGuestBtn", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "uin", "nickname", "", "l", HippyQQHttpModule.HTPP_ERROR_TEXT, "u", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p {
    public static final uc.a b(Context context, int i3) {
        String n3;
        Intrinsics.checkNotNullParameter(context, "context");
        QZoneBlankStateView.a aVar = new QZoneBlankStateView.a();
        int i16 = 20;
        QUIEmptyState.Builder halfScreenState = new QUIEmptyState.Builder(context).setImageType(20).setHalfScreenState(true);
        com.qzone.reborn.configx.g gVar = com.qzone.reborn.configx.g.f53821a;
        QZoneBlankStateView.a b16 = aVar.b(halfScreenState.setTitle(gVar.c().w()).setBackgroundColorType(0));
        String w3 = gVar.c().w();
        if (i3 == 10014) {
            w3 = gVar.c().o();
            n3 = gVar.c().n();
            i16 = 3;
        } else if (i3 != 10023) {
            if (!RFWNetworkUtils.isNetworkAvailable(context)) {
                w3 = gVar.c().q();
                n3 = gVar.c().p();
                i16 = 5;
            } else {
                n3 = "";
            }
        } else {
            w3 = gVar.c().m();
            n3 = gVar.c().l();
            i16 = 1;
        }
        uc.a bean = new uc.a().c(b16).f(new QUIEmptyState.Builder(context).setImageType(i16).setTitle(w3).setDesc(n3).setAutoCenter(true).setHalfScreenState(true).setBackgroundColorType(0));
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    public static final uc.a c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QZoneBlankStateView.a b16 = new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(20).setHalfScreenState(true).setTitle(com.qzone.reborn.configx.g.f53821a.c().s()).setBackgroundColorType(0));
        uc.a bean = new uc.a().c(b16).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle("\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51").setDesc("\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e").setAutoCenter(true).setHalfScreenState(true).setBackgroundColorType(0));
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    public static final uc.a d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QZoneBlankStateView.a b16 = new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(20).setHalfScreenState(true).setTitle(com.qzone.reborn.configx.g.f53821a.c().w()).setBackgroundColorType(0));
        uc.a bean = new uc.a().c(b16).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle("\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51").setDesc("\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e").setAutoCenter(true).setHalfScreenState(true).setBackgroundColorType(0));
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    public static final uc.a e(final Context context, boolean z16) {
        String u16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!z16) {
            u16 = com.qzone.reborn.configx.g.f53821a.c().t();
        } else {
            u16 = com.qzone.reborn.configx.g.f53821a.c().u();
        }
        QZoneBlankStateView.a b16 = new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(20).setHalfScreenState(true).setTitle(u16).setBackgroundColorType(0));
        if (z16) {
            b16.d("\u53d1\u8868\u52a8\u6001");
            b16.c(new View.OnClickListener() { // from class: com.qzone.reborn.feedpro.utils.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    p.f(context, view);
                }
            });
        }
        uc.a bean = new uc.a().c(b16).f(new QUIEmptyState.Builder(context).setImageType(13).setTitle("\u65e0\u6cd5\u8fde\u63a5\u5230\u4e92\u8054\u7f51").setDesc("\u8bf7\u5173\u95ed\u98de\u884c\u6a21\u5f0f\u6216\u68c0\u67e5\u8bbe\u5907\u7684\u7f51\u7edc\u8bbe\u7f6e").setAutoCenter(true).setHalfScreenState(true).setBackgroundColorType(0));
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.q(context, "mqzone://arouse/writemood");
        EventCollector.getInstance().onViewClicked(view);
    }

    public static final uc.a g(MainPageControl mainPageControl, Context context, String title, String desc) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        uc.a bean = new uc.a().c(new QZoneBlankStateView.a().b(new QUIEmptyState.Builder(context).setImageType(o(mainPageControl)).setHalfScreenState(true).setTitle(title).setDesc(desc).setBackgroundColorType(0)));
        Intrinsics.checkNotNullExpressionValue(bean, "bean");
        return bean;
    }

    public static final int h(Context context, int i3) {
        int o16 = pl.a.f426446a.o(context);
        if (i3 == 1) {
            return o16 - ar.d(32.0f);
        }
        if (i3 == 2) {
            return ((o16 - ar.d(32.0f)) - ar.d(5.0f)) / 2;
        }
        if (i3 != 3) {
            return 0;
        }
        return ((o16 - ar.d(32.0f)) - ar.d(10.0f)) / 3;
    }

    public static final FrameLayout i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.co9, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.FrameLayout");
        return (FrameLayout) inflate;
    }

    public static final TextView j(Context context, String btnText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setText(btnText);
        textView.setGravity(17);
        textView.setTextSize(1, 17.0f);
        textView.setTextColor(ContextCompat.getColor(context, R.color.qui_button_text_primary_default));
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        textView.setPadding(0, rVar.e(11), 0, rVar.e(11));
        textView.setBackground(ContextCompat.getDrawable(context, R.drawable.f143422));
        return textView;
    }

    public static final TextView k(Context context, String btnText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(btnText, "btnText");
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setText(btnText);
        textView.setGravity(17);
        textView.setTextSize(1, 17.0f);
        textView.setTextColor(ContextCompat.getColor(context, R.color.qui_button_text_secondary_default));
        com.qzone.reborn.util.r rVar = com.qzone.reborn.util.r.f59560a;
        textView.setPadding(0, rVar.e(11), 0, rVar.e(11));
        textView.setBackground(ContextCompat.getDrawable(context, R.drawable.f143624));
        return textView;
    }

    public static final void l(Activity activity, long j3, String nickname) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nickname, "nickname");
        Intent d16 = com.qzone.common.activities.base.ak.d(activity);
        d16.putExtra("access_apply_uin", j3);
        d16.putExtra("access_apply_nick_name", nickname);
        com.qzone.feed.utils.b.e(activity, d16, 14);
    }

    public static final int o(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        int i3 = mainPageControl.relation;
        if (i3 == 0 || i3 == 2 || i3 == 3) {
            return 1;
        }
        if (i3 == 4) {
            return 20;
        }
        if (i3 != 5) {
            return i3 != 6 ? 20 : 12;
        }
        return 13;
    }

    public static final boolean p(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        return mainPageControl.relation == 4;
    }

    public static final boolean q(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        return mainPageControl.relation != 1;
    }

    public static final boolean r(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        return mainPageControl.isFriend && q(mainPageControl);
    }

    public static final boolean s(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        int i3 = mainPageControl.relation;
        if (i3 == 1 || i3 == 6 || i3 == 5) {
            return !mainPageControl.isFriend && i3 == 1;
        }
        return true;
    }

    public static final boolean t(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        return mainPageControl.relation == 3;
    }

    public static final boolean u(String str) {
        return !TextUtils.equals(str, "\u65e0\u6743\u9650\u8bbf\u95ee");
    }

    public static final boolean v(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        return (mainPageControl.isFriend || q(mainPageControl)) ? false : true;
    }

    public static final boolean w(MainPageControl mainPageControl) {
        Intrinsics.checkNotNullParameter(mainPageControl, "<this>");
        return !mainPageControl.isFriend && q(mainPageControl);
    }

    public static final ArrayList<String> x(Questions questions) {
        Intrinsics.checkNotNullParameter(questions, "<this>");
        ArrayList<String> arrayList = new ArrayList<>();
        QzoneRightQuestion qzoneRightQuestion = questions.question1;
        if (!TextUtils.isEmpty(qzoneRightQuestion != null ? qzoneRightQuestion.question : null)) {
            QzoneRightQuestion qzoneRightQuestion2 = questions.question1;
            Intrinsics.checkNotNull(qzoneRightQuestion2);
            String str = qzoneRightQuestion2.question;
            Intrinsics.checkNotNull(str);
            arrayList.add(str);
        }
        QzoneRightQuestion qzoneRightQuestion3 = questions.question2;
        if (!TextUtils.isEmpty(qzoneRightQuestion3 != null ? qzoneRightQuestion3.question : null)) {
            QzoneRightQuestion qzoneRightQuestion4 = questions.question2;
            Intrinsics.checkNotNull(qzoneRightQuestion4);
            String str2 = qzoneRightQuestion4.question;
            Intrinsics.checkNotNull(str2);
            arrayList.add(str2);
        }
        QzoneRightQuestion qzoneRightQuestion5 = questions.question3;
        if (!TextUtils.isEmpty(qzoneRightQuestion5 != null ? qzoneRightQuestion5.question : null)) {
            QzoneRightQuestion qzoneRightQuestion6 = questions.question3;
            Intrinsics.checkNotNull(qzoneRightQuestion6);
            String str3 = qzoneRightQuestion6.question;
            Intrinsics.checkNotNull(str3);
            arrayList.add(str3);
        }
        return arrayList;
    }

    public static final int n(boolean z16, boolean z17, boolean z18) {
        int e16 = z16 ? com.qzone.reborn.util.r.f59560a.e(68) : 0;
        return pl.a.f426446a.j() + e16 + (z17 ? com.qzone.reborn.util.r.f59560a.e(174) : 0) + (z18 ? com.qzone.reborn.util.r.f59560a.e(82) : 0);
    }

    public static final LinearLayout.LayoutParams m(Context context, int i3) {
        if (i3 == 1) {
            return new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(h(context, 1), -2));
        }
        if (i3 != 2) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(h(context, 3), -2));
            layoutParams.leftMargin = ar.d(2.5f);
            layoutParams.rightMargin = ar.d(2.5f);
            return layoutParams;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(new LinearLayout.LayoutParams(h(context, 2), -2));
        layoutParams2.leftMargin = ar.d(2.5f);
        layoutParams2.rightMargin = ar.d(2.5f);
        return layoutParams2;
    }
}
