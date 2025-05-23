package com.tencent.biz.pubaccount.weishi.util;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stAcquisitionInfo;
import UserGrowth.stBusinessIconInfo;
import UserGrowth.stFeed;
import UserGrowth.stLive;
import UserGrowth.stSchema;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi.profile.WSProfileFragment;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$APPID;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f81782a = {"[em]e212[/em]", "[em]e219[/em]", "[em]e226[/em]", "[em]e233[/em]", "[em]e234[/em]", "[em]e221[/em]", "[em]e228[/em]", "[em]e208[/em]", "[em]e222[/em]", "[em]e229[/em]", "[em]e223[/em]", "[em]e230[/em]", "[em]e240[/em]", "[em]e224[/em]", "[em]e231[/em]", "[em]e211[/em]", "[em]e218[/em]", "[em]e225[/em]", "[em]e232[/em]", "[em]e290[/em]", "[em]e291[/em]", "[em]e256[/em]", "[em]e261[/em]", "[em]e259[/em]", "[em]e235[/em]", "[em]e236[/em]", "[em]e239[/em]"};

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f81783b = Pattern.compile("[@#]\\w+", 2);

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet.OnButtonClickListener f81784d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f81785e;

        a(ActionSheet.OnButtonClickListener onButtonClickListener, ActionSheet actionSheet) {
            this.f81784d = onButtonClickListener;
            this.f81785e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            x.b("WSFeedUtils", "clickedView :" + view + ", which: " + i3);
            ActionSheet.OnButtonClickListener onButtonClickListener = this.f81784d;
            if (onButtonClickListener != null) {
                onButtonClickListener.onClick(view, i3);
            }
            this.f81785e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet.OnDismissListener f81786d;

        b(ActionSheet.OnDismissListener onDismissListener) {
            this.f81786d = onDismissListener;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            x.b("WSFeedUtils", "onDismiss entered");
            ActionSheet.OnDismissListener onDismissListener = this.f81786d;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l f81787d;

        c(l lVar) {
            this.f81787d = lVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            l lVar = this.f81787d;
            if (lVar != null) {
                lVar.a();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements OuterInterceptManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f81788a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f81789b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WSDownloadParams f81790c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f81791d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f81792e;

        d(Activity activity, String str, WSDownloadParams wSDownloadParams, String str2, int i3) {
            this.f81788a = activity;
            this.f81789b = str;
            this.f81790c = wSDownloadParams;
            this.f81791d = str2;
            this.f81792e = i3;
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void a(Dialog dialog) {
            WSPublicAccReport.getInstance().reportCallDialog("gzh_exposure", "dynamics_" + this.f81791d + this.f81792e, 0);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void b() {
            Activity activity = this.f81788a;
            String str = this.f81789b;
            WSDownloadParams wSDownloadParams = this.f81790c;
            ao.f(activity, "biz_src_jc_gzh_weishi", str, wSDownloadParams.mScene, wSDownloadParams.mLinkStrategyType, wSDownloadParams.mEventId);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void onNegativeClick() {
            WSPublicAccReport.getInstance().reportCallDialog("gzh_click", "dynamics_" + this.f81791d + this.f81792e, QAdConfigDefine$APPID.QQLIVE);
        }

        @Override // com.tencent.biz.pubaccount.weishi.util.OuterInterceptManager.a
        public void onPositiveClick() {
            WSPublicAccReport.getInstance().reportCallDialog("gzh_click", "dynamics_" + this.f81791d + this.f81792e, 1000001);
            Activity activity = this.f81788a;
            String str = this.f81789b;
            WSDownloadParams wSDownloadParams = this.f81790c;
            ao.f(activity, "biz_src_jc_gzh_weishi", str, wSDownloadParams.mScene, wSDownloadParams.mLinkStrategyType, wSDownloadParams.mEventId);
        }
    }

    public static void A(Activity activity, stSchema stschema, int i3, stSimpleMetaPerson stsimplemetaperson) {
        String str;
        if (u(stsimplemetaperson)) {
            B(activity, stschema, i3);
        } else {
            WSProfileFragment.qi(activity, stsimplemetaperson);
        }
        if (stsimplemetaperson != null) {
            str = stsimplemetaperson.f25130id;
        } else {
            str = "";
        }
        if (stschema.type == 1) {
            if (TextUtils.equals(str, bb.q())) {
                bb.W("homepage_main");
            } else {
                bb.W("homepage_guest");
            }
        }
    }

    public static void D() {
        ai.k("key_player_mute_guide_show", true);
    }

    public static void E(View.OnClickListener onClickListener, View... viewArr) {
        for (View view : viewArr) {
            if (view != null) {
                view.setOnClickListener(onClickListener);
            }
        }
    }

    public static void F(int i3, View... viewArr) {
        for (View view : viewArr) {
            if (view.getVisibility() != i3) {
                view.setVisibility(i3);
            }
        }
    }

    public static void G(Context context, ActionSheet.OnButtonClickListener onButtonClickListener, ActionSheet.OnDismissListener onDismissListener) {
        ActionSheet create = ActionSheet.create(context);
        create.addButton("\u53d6\u6d88\u5173\u6ce8", 3);
        create.addCancelButton("\u53d6\u6d88");
        create.setOnButtonClickListener(new a(onButtonClickListener, create));
        create.setOnDismissListener(new b(onDismissListener));
        create.show();
    }

    public static int H(float f16) {
        return ScreenUtil.dip2px(f16);
    }

    private static void a(List<WSVideoPreDownloadManager.c> list, List<stFeed> list2, int i3) {
        stSimpleMetaFeed stsimplemetafeed;
        if (list2.size() <= i3 || i3 < 0 || (stsimplemetafeed = list2.get(i3).feed) == null) {
            return;
        }
        list.add(com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.d(stsimplemetafeed));
    }

    public static SpannableStringBuilder d(String str, String str2, String str3, int i3, boolean z16, l lVar) {
        SpannableStringBuilder append = new SpannableStringBuilder(str).append((CharSequence) "\uff1a").append(e(str2));
        append.setSpan(new c(lVar), 0, str.length() + 1, 33);
        if (z16) {
            append.setSpan(new StyleSpan(1), 0, str.length() + 1, 33);
        }
        append.setSpan(new ForegroundColorSpan(i3), 0, str.length() + 1, 33);
        b(append);
        return append;
    }

    private static CharSequence e(CharSequence charSequence) {
        for (String str : f81782a) {
            charSequence = charSequence.toString().replace(str, "");
        }
        return charSequence;
    }

    public static int f(int i3, stMetaUgcVideoSeg stmetaugcvideoseg) {
        String str;
        if (stmetaugcvideoseg != null && stmetaugcvideoseg.width != 0) {
            x.b("WSFeedUtils", "[getClippedVideoHeight] width: " + stmetaugcvideoseg.width + ", height: " + stmetaugcvideoseg.height);
            int i16 = stmetaugcvideoseg.height;
            int i17 = stmetaugcvideoseg.width;
            if (i16 > i17) {
                return (i3 * 4) / 3;
            }
            return (i3 * i16) / i17;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[getClippedVideoHeight] ");
        if (stmetaugcvideoseg == null) {
            str = "video is null";
        } else {
            str = "video width is zero";
        }
        sb5.append(str);
        x.f("WSFeedUtils", sb5.toString());
        return (i3 * 4) / 3;
    }

    public static int g(int i3) {
        return h().getResources().getColor(i3);
    }

    public static Context h() {
        return BaseApplication.getContext();
    }

    public static Drawable i(int i3) {
        return h().getResources().getDrawable(i3);
    }

    public static String j(int i3, Object... objArr) {
        return String.format(BaseApplicationImpl.getApplication().getString(i3), objArr);
    }

    public static stSimpleMetaFeed k(List<stSimpleMetaFeed> list) {
        stSimpleMetaFeed stsimplemetafeed = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            stSimpleMetaFeed stsimplemetafeed2 = list.get(size);
            if (stsimplemetafeed2.video_type != 2) {
                if (!TextUtils.isEmpty(stsimplemetafeed2.feed_desc)) {
                    return stsimplemetafeed2;
                }
                stsimplemetafeed = stsimplemetafeed2;
            }
        }
        return stsimplemetafeed;
    }

    public static int l(int i3) {
        switch (i3) {
            case 1:
            case 2:
            case 4:
                return R.drawable.f162661od1;
            case 3:
                return R.drawable.ocz;
            case 5:
                return R.drawable.f162660od0;
            case 6:
                return R.drawable.f162662od2;
            default:
                return -1;
        }
    }

    public static String m(int i3) {
        return BaseApplicationImpl.getApplication().getString(i3);
    }

    public static List<WSVideoPreDownloadManager.c> n(List<stFeed> list, int i3, boolean z16) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        if (z16) {
            int i16 = i3 + 1;
            for (int i17 = i16; i17 < i16 + 3; i17++) {
                a(arrayList, arrayList2, i17);
            }
        } else {
            int i18 = i3 - 1;
            for (int i19 = i18; i19 > i18 - 3; i19--) {
                a(arrayList, arrayList2, i19);
            }
        }
        return arrayList;
    }

    public static int o(View view) {
        Rect rect = new Rect();
        if (view.getLocalVisibleRect(rect)) {
            return (rect.height() * 100) / view.getHeight();
        }
        return -1;
    }

    public static WSDownloadParams p(String str, int i3) {
        WSDownloadParams wSDownloadParams = new WSDownloadParams();
        wSDownloadParams.mScene = 9;
        wSDownloadParams.mLinkStrategyType = iz.a.g().p();
        wSDownloadParams.mEventId = i3;
        wSDownloadParams.mTestId = bb.x(1);
        wSDownloadParams.mStReportItem = com.tencent.biz.pubaccount.weishi.report.a.g();
        wSDownloadParams.mScheme = str;
        return wSDownloadParams;
    }

    public static boolean r(int i3) {
        if (i3 == 1 || i3 == 3) {
            return true;
        }
        return false;
    }

    public static boolean s(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public static boolean t() {
        return ai.b("key_player_mute_guide_show", false);
    }

    public static void w(Activity activity, String str, int i3, int i16, String str2) {
        x.b("WSFeedUtils", "[openWeishiViaScheme] scheme: " + str + ", eventId: " + i3);
        if (activity == null) {
            return;
        }
        WSDownloadParams p16 = p(str, i3);
        if (com.tencent.biz.qqstory.utils.l.c(activity)) {
            OuterInterceptManager.a(activity, new d(activity, str, p16, str2, i16));
        }
    }

    public static String y(String str) {
        return TextUtils.isEmpty(str) ? m(R.string.f161491xv) : str;
    }

    public static String z(int i3) {
        x.b("WSFeedUtils", "feed create time: " + i3 + ", corresponding date: " + new Date(i3 * 1000));
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - ((long) i3);
        StringBuilder sb5 = new StringBuilder();
        if (currentTimeMillis >= 0 && currentTimeMillis < 60) {
            return m(R.string.f161471xt);
        }
        if (currentTimeMillis >= 60 && currentTimeMillis < 3600) {
            sb5.append(currentTimeMillis / 60);
            sb5.append(m(R.string.f161481xu));
            return sb5.toString();
        }
        if (currentTimeMillis >= 3600 && currentTimeMillis < 86400) {
            sb5.append(currentTimeMillis / 3600);
            sb5.append(m(R.string.f161461xs));
            return sb5.toString();
        }
        if (currentTimeMillis >= 86400 && currentTimeMillis < 2592000) {
            sb5.append(currentTimeMillis / 86400);
            sb5.append(m(R.string.f161421xo));
            return sb5.toString();
        }
        sb5.append(30);
        sb5.append(m(R.string.f161421xo));
        return sb5.toString();
    }

    public static void B(Activity activity, stSchema stschema, int i3) {
        C(activity, stschema, i3, 0, "");
    }

    public static boolean q(List list) {
        return list == null || list.isEmpty();
    }

    public static void C(Activity activity, stSchema stschema, int i3, int i16, String str) {
        if (stschema == null) {
            return;
        }
        int i17 = stschema.type;
        if (i17 == 1) {
            com.tencent.biz.pubaccount.weishi.z.o(activity, stschema.miniAppSchema, null);
        } else if (i17 == 2) {
            w(activity, stschema.schema, i3, i16, str);
        } else {
            if (i17 != 3) {
                return;
            }
            com.tencent.biz.pubaccount.weishi.z.h(activity, stschema.H5Url);
        }
    }

    private static void b(SpannableStringBuilder spannableStringBuilder) {
        if (spannableStringBuilder == null) {
            return;
        }
        Matcher matcher = f81783b.matcher(spannableStringBuilder);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            x.l("WSFeedUtils", "subStr:" + spannableStringBuilder.subSequence(start, end).toString());
            spannableStringBuilder.setSpan(new StyleSpan(1), start, end, 33);
        }
    }

    public static SpannableStringBuilder c(String str, String str2, String str3) {
        return d(str, str2, str3, g(R.color.weishi_color_skin_comment_text), true, null);
    }

    public static boolean u(stSimpleMetaPerson stsimplemetaperson) {
        stLive stlive;
        return (stsimplemetaperson == null || (stlive = stsimplemetaperson.live) == null || stlive.status != 1) ? false : true;
    }

    public static boolean v(stSimpleMetaFeed stsimplemetafeed) {
        stAcquisitionInfo stacquisitioninfo;
        stBusinessIconInfo stbusinessiconinfo;
        return (stsimplemetafeed == null || (stacquisitioninfo = stsimplemetafeed.acquisitionInfo) == null || (stbusinessiconinfo = stacquisitioninfo.businessIcon) == null || stbusinessiconinfo.type != 10000) ? false : true;
    }

    public static void x(TextView textView, int i3, boolean z16) {
        if (textView == null || z16) {
            return;
        }
        textView.setVisibility(0);
        int l3 = l(i3);
        if (l3 == -1) {
            textView.setVisibility(8);
        } else {
            textView.setBackgroundResource(l3);
        }
    }
}
